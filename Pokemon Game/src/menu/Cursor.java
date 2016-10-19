package menu;

import gfx.SpriteSheet;
import gfx.StaticImage;

public class Cursor extends StaticImage {
	public Cursor(){
		width = 8;
		height = 8;
		pixels = new SpriteSheet("/cursor.png").getPixels();
	}
	public Cursor(int x, int y){
		width = 8;
		height = 8;
		pixels = new SpriteSheet("/cursor.png").getPixels();
		xPos = x;
		yPos = y;
	}
	
}
