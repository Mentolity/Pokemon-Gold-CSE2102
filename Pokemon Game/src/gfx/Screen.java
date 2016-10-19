package gfx;

import menu.Textbox;

public class Screen {
	public static final int MAP_WIDTH = 64;
	public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;
	
	public int[] pixels;
	
	public int xOffset = 360*16;
	public int yOffset = 220*16;
	//public int xOffset = 0;
	//public int yOffset = 0;
	
	public int width;
	public int height;
	
	public Screen(int width, int height, SpriteSheet sheet){
		this.width = width;
		this.height = height;
		 
		pixels = new int[width*height];
		
	}
	
	public void renderSprite(int xPos, int yPos, int xtile, int ytile, SpriteSheet sheet){
		renderSprite(xPos, yPos, xtile, ytile, false, false, 16, 16, sheet);
	}
	
	public void renderSprite(int xPos, int yPos, int xtile, int ytile, int width, int height, SpriteSheet sheet){
		renderSprite(xPos, yPos, xtile, ytile, false, false, width, height, sheet);
	}
	

	//improved render method
	public void renderSprite(int xPos, int yPos, int xTile, int yTile, boolean mirrorX, boolean mirrorY, int spriteWidth, int spriteHeight, SpriteSheet sheet){
		xPos -= xOffset;
		yPos -= yOffset;
		
		for(int y=0; y<spriteHeight; y++){
			int ySheet = y;
			if(mirrorY) ySheet = (spriteHeight-1)-y;
			if(y + yPos < 0 || y + yPos >= height) continue;
			for(int x=0; x<spriteWidth; x++){
				int xSheet = x;
				if(mirrorX) xSheet = (spriteWidth-1)-x;
				if(x + xPos < 0 || x + xPos >= width) continue;
				
				int col = sheet.getPixels()[xSheet+(xTile*16) + ((ySheet+(yTile*16)) * sheet.getWidth())];
				if (((col & 0xffffff) != 0xff00ff) && ((col & 0xffffff) != 0x7f007f))//removes the sprite sheets grid colors
					pixels[(x+xPos) + (y+yPos) * width] = col;
				
			}
		}
	}
		
	public void renderStaticImage(StaticImage img){
		int xPos = img.xPos;
		int yPos = img.yPos;
		int imgwidth = img.width;
		int imgheight = img.height;
		for(int y=0; y<height; y++){
			if(y < yPos || y >= yPos+imgheight) continue;
			for(int x=0; x<width; x++){
				if(x < xPos || x >= xPos+imgwidth) continue;
				pixels[(x) + (y) * width] = img.pixels[(x-xPos) + ((y-yPos) * imgwidth)];
			}
		}
	}
	
	public void renderMap(Map map){
		renderMap(0, 0, map);
	}
	
	public void renderMap(int xPos, int yPos, Map map){
		xPos += xOffset;
		yPos += yOffset;
		
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				pixels[(x) + ((y) * width)] = 0x000000;
			}
		}
		
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				if((x + xPos < 0 || x + xPos >= map.getWidth()) || (y + yPos < 0 || y + yPos >= map.getHeight())){
					pixels[(x) + ((y) * width)] = 0xFF000000; //if were out of the maps bounds then render black
				}else{
					pixels[(x) + ((y) * width)] = map.getPixels()[x+xPos + ((y+yPos)*map.getWidth())];	//else render the map
				}	
			}
		}
	}
}






