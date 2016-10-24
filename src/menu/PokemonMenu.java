package menu;

import pokemon.Pokemon;
import game.InputHandler;
import gfx.Text;
import gfx.Textbox;
import gfx.WhiteSpace;

public class PokemonMenu extends Menu {
	public int size;
	public PokemonMenu(Menu ref){
		size = -1;
		options = new Option[6];
		last = ref;
		cursor.setPos(0, 6);
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

	public void addPokemon(Pokemon p){
		size++;
		for(int y=0;y<6;y++){
			if(options[y]==null){
				options[y] = new PokemonOption(p).setPos(7, (y*18)+4);
				break;
			}
		}
	}
	public void updateCursor(){
		cursor.setPos(0, 6);
	}
	public void navigate(InputHandler input) {
		if(input.up.isPressed()){
			if(input.up.ticksPressed()<=1){
				if(loc==0) loc = size;
				else loc--;
				cursor.setPos(0,(loc*18)+6);
			}	
		}
		else if(input.down.isPressed()){
			if(input.down.ticksPressed()<=1){
				if(loc==size) loc = 0;
				else loc++;
				cursor.setPos(0,(loc*18)+6);
			}	
		}
		if(input.z.isPressed()){
			//if(input.z.ticksPressed()>1) next = options[loc].select();		
		}
		
	}
}
