package save;

import menu.ItemOption;
import menu.PokemonOption;

public class Player {
	public String name;
	public ItemOption items[] = new ItemOption[100];
	public PokemonOption pokemon[] = new PokemonOption[6];
	public Player(String s, ItemOption[] i, PokemonOption[] p){
		name = s;
		items = i;
		pokemon = p;
	}
}
