package menu;

import pokemon.Item;
import pokemon.Pokemon;
import game.InputHandler;
import gfx.Text;
import gfx.Textbox;
import gfx.WhiteSpace;

public class MainMenu extends Menu {
	public Text textsArray[][];
	public MainMenu(){
		cursor.setPos(88,12);
		white = new WhiteSpace[]{
				new WhiteSpace(0,100,80,44)
				};
		boxes = new Textbox[]{
				new Textbox(80,0,10,18)
				};
		last = null;
		textsArray = new Text[][]{
				new Text[]{
				new Text("Party"),
				new Text("Status")
				},
				new Text[]{
				new Text("Pokemon"),
				new Text("Database")
				},
				new Text[]{
				new Text("Contains"),
				new Text("items")
				},
				new Text[]{
				new Text("Trainer"),
				new Text("Directory")
				},
				new Text[]{
				new Text("Player"),
				new Text("Menu")
				},
				new Text[]{
				new Text("Save"),
				new Text("Game")
				},
				new Text[]{
				new Text("Change"),
				new Text("Settings")
				},
				new Text[]{
				new Text("Exit"),
				new Text("Game")
				}
		};
		for(int y=0;y<textsArray.length;y++){
			textsArray[y][0].setPos(8, 106);
			textsArray[y][1].setPos(8, 124);
		}
		texts = textsArray[0];
		init();
	}
	public void init(){
		PokemonMenu pokemonmenu = new PokemonMenu(this);
		pokemonmenu.addPokemon(new Pokemon("Cyndaquil", 20, 95, new Item()));
		pokemonmenu.addPokemon(new Pokemon("Toadadile", 60, 190, null));
		pokemonmenu.addPokemon(new Pokemon("Chikorita", 10, 10, new Item()));
		pokemonmenu.addPokemon(new Pokemon("Pikachu", 100, 200, null));
		pokemonmenu.addPokemon(new Pokemon("Charizard", 8, 10, new Item()));
		pokemonmenu.addPokemon(new Pokemon("Groudon", 224, 257, null));
		options=new Option[]{
				new MenuOption("Pokemon", pokemonmenu).setPos(96, 12),
				new MenuOption("Pokedex", new PokedexMenu(this)).setPos(96, 28),
				new MenuOption("Pack", new PackMenu(this)).setPos(96, 44),
				new MenuOption("Gear", new GearMenu(this)).setPos(96, 60),
				new MenuOption("Player", new PlayerMenu(this)).setPos(96, 76),
				new MenuOption("Save", new SaveMenu(this)).setPos(96, 92),
				new MenuOption("Option", new OptionMenu(this)).setPos(96, 108),
				new MenuOption("Exit", new ExitMenu(this)).setPos(96, 124),
				};
	}
	public void updateCursor(){
		cursor.setPos(88,12);
		texts = textsArray[0];
	}
	public void navigate(InputHandler input) {
		if(input.up.isPressed()){
			if(input.up.ticksPressed()<=1){
				if(loc==0) loc = 7;
				else loc--;
				cursor.setPos(88,(loc*16)+12);
				texts = textsArray[loc];
			}	
		}
		else if(input.down.isPressed()){
			if(input.down.ticksPressed()<=1){
				if(loc==7) loc = 0;
				else loc++;
				cursor.setPos(88,(loc*16)+12);
				texts = textsArray[loc];
			}	
		}
		if(input.z.isPressed()){
			if(input.z.ticksPressed()>1) next = options[loc].select();		
		}
	}
}
