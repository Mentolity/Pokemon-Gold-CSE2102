package menu;

import game.Game;
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
		Game.running = false;
		System.exit(0);
	}
}
