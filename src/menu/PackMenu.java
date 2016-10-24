package menu;

import game.InputHandler;
import gfx.Textbox;

public class PackMenu extends Menu {
	public PackMenu(Menu ref){
		last = ref;
		boxes = new Textbox[]{
				new Textbox(0, 96, 20, 6)
				};
	}
	public void updateCursor(){
		cursor.setPos(88,12);
	}
	public void navigate(InputHandler input) {
		
	}
}
