package menu;

import game.InputHandler;

public class PokemonMenu extends Menu {
	public PokemonMenu(Menu ref){
		last = ref;
		cursor = new Cursor(12, 12);
		white = new WhiteSpace[]{
				new WhiteSpace(0,0,160,112)
		};
		boxes = new Textbox[]{
				new Textbox(0,112,20,4)
		};
		texts = new Text[]{
				new Text("Choose a Pokemon", 12, 124)
		};
	}

	@Override
	public void navigate(InputHandler input) {
		// TODO Auto-generated method stub
		
	}
}
