package menu;

import game.InputHandler;

public class MainMenu extends Menu {
	public MainMenu(){
		cursor = new Cursor(88,12);
		white = new WhiteSpace[]{
				new WhiteSpace(0,100,80,44)
				};
		options=new Option[]{
				new MenuOption("Pokemon", new PokemonMenu(this)).setPos(96, 12),
				new MenuOption("Pokedex", new PokedexMenu(this)).setPos(96, 28),
				new MenuOption("Pack", new PackMenu(this)).setPos(96, 44),
				new MenuOption("Gear", new GearMenu(this)).setPos(96, 60),
				new MenuOption("Player", new PlayerMenu(this)).setPos(96, 76),
				new MenuOption("Save", new SaveMenu(this)).setPos(96, 92),
				new MenuOption("Option", new OptionMenu(this)).setPos(96, 108),
				new MenuOption("Exit", new ExitMenu(this)).setPos(96, 124),
				};
		boxes = new Textbox[]{
				new Textbox(80,0,10,18)
				};
		last = null;
	}

	public void navigate(InputHandler input) {
		if(input.up.isPressed()){
			if(input.up.ticksPressed()<=1){
				if(loc==0) loc = 7;
				else loc--;
				cursor.setPos(88,(loc*16)+12);
			}	
		}
		else if(input.down.isPressed()){
			if(input.down.ticksPressed()<=1){
				if(loc==7) loc = 0;
				else loc++;
				cursor.setPos(88,(loc*16)+12);
			}	
		}
		if(input.z.isPressed()){
			if(input.z.ticksPressed()>1) next = options[loc].select();		
		}
	}
}
