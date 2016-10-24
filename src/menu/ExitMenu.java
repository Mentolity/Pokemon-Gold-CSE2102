package menu;

import game.InputHandler;

public class ExitMenu extends Menu {

	public ExitMenu(Menu ref) {
		last = ref;
	}
	@Override
	public void updateCursor(){
		cursor.setPos(88,12);
	}
	public void navigate(InputHandler input) {
		// TODO Auto-generated method stub

	}
}
