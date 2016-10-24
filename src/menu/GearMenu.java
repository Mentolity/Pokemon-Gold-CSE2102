package menu;

import game.InputHandler;


public class GearMenu extends Menu {

	public GearMenu(Menu ref) {
		last = ref;
	}
	public void updateCursor(){
		cursor.setPos(88,12);
	}
	@Override
	public void navigate(InputHandler input) {
		// TODO Auto-generated method stub

	}

}
