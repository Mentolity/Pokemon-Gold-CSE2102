package menu;

import gfx.Screen;

public abstract class Option {
	public abstract void render(Screen screen);	
	public abstract Option setPos(int x, int y);
	public abstract Menu select();
}
