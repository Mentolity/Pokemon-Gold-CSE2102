package menu;

import gfx.Screen;

public abstract class Option {
	public Text text;
	public void render(Screen screen){
		screen.renderStaticImage(text);
	}
	public Option setPos(int x, int y){
		text.setPos(x, y);
		return this;
	}
	public abstract Menu select();
}
