package pokemon;


public class Pokemon {
	public enum Gender{Male, Female};
	public String name;
	public int health;
	public int maxHealth;
	public Status status;
	public Item item;
	public Pokemon(String n, int h, int mH, Item i){
		name = n;
		health = h;
		maxHealth = mH;
		item = i;
	}
}
