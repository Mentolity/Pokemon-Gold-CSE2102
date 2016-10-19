package menu;

import gfx.SpriteSheet;
import gfx.StaticImage;

public class WhiteSpace extends StaticImage {
	public WhiteSpace(int x, int y, int w, int h){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		template = new SpriteSheet("/white.png").getPixels();
		pixels = new int[height*width];
		init();
	}
	public void init(){
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				pixels[x + y * width] = template[0];
			}
		}
	}
}
