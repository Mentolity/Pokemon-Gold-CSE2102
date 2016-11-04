package menu;

import save.Save;
import gfx.Screen;
import gfx.Text;

public class SaveOption extends Option {
	public Save save;
	public Text title;
	public SaveOption(Save s){
		save = s;
		title = new Text(save.user.name);
	}
	public void render(Screen screen) {
		screen.renderStaticImage(title);
	}
	public Option setPos(int x, int y) {
		title.setPos(x, y);
		return this;
	}
	public Menu select() {
		return null;
	}

}
