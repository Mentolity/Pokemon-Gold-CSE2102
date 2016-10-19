package menu;

import gfx.SpriteSheet;
import gfx.StaticImage;

public class Textbox extends StaticImage{
	public Textbox(int x, int y, int tilewidth, int tileheight){
		template = new SpriteSheet("/textbox.png").getPixels();
		xPos = x;
		yPos = y;
		width = tilewidth*8;
		height = tileheight*8;
		pixels = new int[width*height];
		this.init();
	}
	public void init(){
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				if(y<8 && x<8){
					pixels[x + (y * width)] = template[x + (y * 24)];
				}
				else if(y<8 && x>=8 && x<=width-8){ 
					pixels[x + (y * width)] = template[(x%8)+ 8 + (y * 24)];
				}
				else if(y<8 && x>width-8){
					pixels[x + (y * width)] = template[(x%8)+16 + (y * 24)];
				}
				else if(y>=8 && y<=height-8 && x<8){
					pixels[x + (y * width)] = template[x + (((y%8) + 8)* 24)];
				}
				else if(y>=8 && y<=height-8 && x>=8 && x<=width-8){
					pixels[x + (y * width)] = template[(x%8)+8 + (((y%8)+8) * 24)];
				}
				else if(y>=8 && y<=height-8 && x>width-8){
					pixels[x + (y * width)] = template[(x%8)+16 + (((y%8)+8) * 24)];
				}
				else if(y>height-8 && x<8){
					pixels[x + (y * width)] = template[x + (((y%8)+16) * 24)];
				}
				else if(y>height-8 && x>=8 && x<=width-8){
					pixels[x + (y * width)] = template[(x%8)+ 8 + (((y%8)+16) * 24)];
				}
				else if(y>height-8 && x>width-8){
					pixels[x + (y * width)] = template[(x%8)+16 + (((y%8)+16) * 24)];
				}
			}
		}
			
	}
}
