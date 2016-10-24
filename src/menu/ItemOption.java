package menu;

import pokemon.Item;
import gfx.Screen;

public class ItemOption extends Option{
	public Item item;
	public int quantity;
	public Menu menu;
	public void render(Screen screen) {
		
	}
	public Option setPos(int x, int y) {
		return this;
	}
	public Menu select() {
		return menu;
	}

}
