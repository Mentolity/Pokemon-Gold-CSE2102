package menu;

import gfx.Screen;
import gfx.Text;

public class MenuOption extends Option {
	public Menu menu;
	public Text text;
	public MenuOption(String title, Menu menu){
		text = new Text(title);
		this.menu = menu;
	}
	public Menu select(){
		if(menu==null) return null;
		menu.updateCursor();
		menu.open();
		return menu;
	}
	public void render(Screen screen) {
		screen.renderStaticImage(text);		
	}
	public Option setPos(int x, int y) {
		text.setPos(x, y);
		return this;
	}
}
