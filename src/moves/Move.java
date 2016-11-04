package moves;

public abstract class Move {
	public int power, accuracy;
	public enum Type {NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON,
		GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY};
	public Type t;
	
}
