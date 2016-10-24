package menu;

import gfx.SpriteSheet;
import gfx.StaticImage;

public class PackMenuTemplate extends StaticImage{
	public PackMenuTemplate(){
		pixels = new SpriteSheet("/PackMenuTemplate.png").getPixels();
		setPos(0, 0);
	}
}
