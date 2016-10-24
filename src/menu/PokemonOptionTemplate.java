package menu;

import gfx.SpriteSheet;
import gfx.StaticImage;

public class PokemonOptionTemplate extends StaticImage{
	public PokemonOptionTemplate(){
		width=152;
		height=18;
		pixels = new SpriteSheet("/PokemonOption.png").getPixels();
	}
}
