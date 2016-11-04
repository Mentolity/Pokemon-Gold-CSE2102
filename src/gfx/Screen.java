package gfx;

import java.util.ArrayList;

import game.Game;

public class Screen {
	public static final int MAP_WIDTH = 64;
	public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;
	
	public int[] pixels;
	
	public int xOffset = 360*16;
	public int yOffset = 220*16;
	/*public int xOffset = 4112;
	public int yOffset = 3520;*/
	
	public int width;
	public int height;
	
	private SpriteSheet sheet;
	
	public Screen(int width, int height, SpriteSheet sheet){
		this.width = width;
		this.height = height;
		 
		pixels = new int[width*height];
		this.sheet = sheet;
	}
	
	
	
	public int[] getPixels(){
		return pixels;
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
		
		//Initially write a black frame to pixels
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
		
		renderMapAnimation(xPos, yPos, map);
	}
	
	//after the rendering the map render the current animation phase over it
	//check if the current pixel in the map.mpPixels is 0x0f00ff and if so render water animation
	public void renderMapAnimation(int xPos, int yPos, Map map){	
		//render over the whole visible screen and 1 extra tile in every direction off the screen
		//this is to render animation tiles that are partially clipped
		for(int y=-16; y<height+16; y++){
			for(int x=-16; x<width+16; x++){
				if((x + xPos < 0 || x + xPos >= map.getWidth()) || (y + yPos < 0 || y + yPos >= map.getHeight())){
					//pixels[(x) + ((y) * width)] = 0xFF000000; //if were out of the maps bounds then render black
					continue;
				}else{
					//System.out.println("x+xPos: " + (x+xPos));
					//System.out.println("y+yPos: " + (y+yPos));
					int col = map.getPointPixels()[x+xPos + ((y+yPos)*map.getWidth())];
					if(col == 0xFFFFFF00){//if yellow render the water animation starting from that point
						switch(map.getAnimationTickPosition()){
						case 0: 
							renderWaterAnimation(x, y, 5, 0, 16, 16, map);
							break;
						case 1:
							renderWaterAnimation(x, y, 2, 0, 16, 16, map);
							break;
						case 2:
							renderWaterAnimation(x, y, 3, 0, 16, 16, map);
							break;
						case 3:
							renderWaterAnimation(x, y, 4, 0, 16, 16, map);
							break;
						default:
							renderWaterAnimation(x, y, 5, 0, 16, 16, map);
							break;
						}
					}
				}	
			}
		}
	}
	
	public void renderWaterAnimation(int xPos, int yPos, int xTile, int yTile, int spriteWidth, int spriteHeight, Map map){	
		for(int y=0; y<spriteHeight; y++){
			if(y + yPos < 0 || y + yPos >= height) continue;
			for(int x=0; x<spriteWidth; x++){
				if(x + xPos < 0 || x + xPos >= width) continue;
				int col = sheet.getPixels()[x+(xTile*16) + ((y+(yTile*16)) * sheet.getWidth())];
				if (((col & 0xffffff) != 0xff00ff) && ((col & 0xffffff) != 0x7f007f)){//removes the sprite sheets grid colors
					int mapColor = map.getPointPixels()[x+xPos+xOffset + ((y+yPos+yOffset)*map.getWidth())];
					int mapColorRight1 = map.getPointPixels()[x+xPos+xOffset+1 + ((y+yPos+yOffset)*map.getWidth())];
					//if the yellow pixel isn't part of the water then skip rendering that point
					if (mapColor == 0xFFFFFF00 && mapColorRight1 != 0xFF0F00FF)
						continue;
					if(mapColor == 0xFF0F00FF || mapColor == 0xFFFFFF00){
						pixels[(x+xPos) + (y+yPos) * width] = col;
					}
				}
			}
		}
	}
	
}



































