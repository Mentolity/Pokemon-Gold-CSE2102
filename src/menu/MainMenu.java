package menu;

import save.Player;
import game.AudioInit;
import game.Effect;
import game.InputHandler;
import gfx.Text;
import gfx.Textbox;
import gfx.WhiteSpace;

public class MainMenu extends Menu {
	public Text textsArray[][];
	public MainMenu(Player player){
		cursor.setPos(88,12);
		white = new WhiteSpace[]{
				new WhiteSpace(0,100,80,44)
				};
		boxes = new Textbox[]{
				new Textbox(80,0,10,18)
				};
		last = null;
		PackMenus = new PackMenu[]{
				new ItemMenu(this),
				new KeyItemMenu(this),
				new PokeballItemMenu(this),
				new HmItemMenu(this)
		};
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
		init(player);
	}
	public void init(Player player){
		PokemonMenu pokemonmenu = new PokemonMenu(this);
		for(int x=0;x<player.items.length;x++) if(player.items[x]!=null) PackMenus[player.items[x].itemPackID].addItem(player.items[x]);
		for(int x=0;x<player.pokemon.length;x++) if(player.pokemon[x]!=null) pokemonmenu.addPokemon(player.pokemon[x]);
		options=new Option[]{
				new MenuOption("Pokemon", pokemonmenu).setPos(96, 12),
				new MenuOption("Pokedex", new PokedexMenu(this)).setPos(96, 28),
				new MenuOption("Pack", PackMenus[0]).setPos(96, 44),
				new MenuOption("Gear", new GearMenu(this)).setPos(96, 60),
				new MenuOption(player.name, new PlayerMenu(this)).setPos(96, 76),
				new MenuOption("Save", new SaveMenu(this)).setPos(96, 92),
				new MenuOption("Option", new OptionMenu(this)).setPos(96, 108),
				new MenuOption("Exit", new ExitMenu(this)).setPos(96, 124),
				};
	}
	public void updateCursor(){
		cursor.setPos(88,(loc*16)+12);
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
			if(input.z.ticksPressed()>1) 
				{
					Effect menuSelect = new Effect (AudioInit.effectPaths.get(4));
					menuSelect.start();
					next = options[loc].select();		
				}
		}
	}
}
