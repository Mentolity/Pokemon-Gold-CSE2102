package menu;

import gfx.SpriteSheet;
import gfx.StaticImage;

public class PackMenuTemplate extends StaticImage{
	public static int template[] = new SpriteSheet("/PackMenuTemplate.png").getPixels();
	public PackMenuTemplate(){
		xPos = 0;
		yPos = 0;
		width = 160;
		height = 96;
		pixels = template;
	}
}
