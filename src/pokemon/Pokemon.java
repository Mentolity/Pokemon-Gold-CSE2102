package pokemon;



public abstract class Pokemon {
	public String name;
	public String description;
	public int ID, catchRate, fleeChance;
	public int baseMaxHP, baseAttack, baseDefense, baseSpecialAttack, baseSpecialDefense, baseSpeed;
	public int IVmaxHP, IVattack, IVdefense, IVspecialAttack, IVspecialDefense, IVspeed;
	//public int EVmaxHP, EVattack, EVdefense, EVspecialAttack, EVspecialDefense, EVspeed;
	public int level, currentHP, maxHP, attack, defense, specialAttack, specialDefense, speed;
	public enum Type {NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON,
		GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY};
	public enum Gender{Male, Female};
	public Type t;
	public Gender g;
	public Status status;
	public Item item;
	/*Stat = floor((2 * B + I + E) * L / 100 + L + 10)
	 * B = base stat
	 * I = IV
	 * E = Effort Value (NOT IMPLEMENTED)
	 * L = Level
	 */
	public void calculateStats(Pokemon p) {
		p.maxHP				=(int) Math.floor(((2*p.baseMaxHP+p.IVmaxHP)*p.level)/(110+p.level));
		p.currentHP			= maxHP;
		p.attack			=(int) Math.floor(((2*p.baseAttack+p.IVattack)*p.level)/(110+p.level));
		p.defense			=(int) Math.floor(((2*p.baseDefense+p.IVdefense)*p.level)/(110+p.level));
		p.specialAttack		=(int) Math.floor(((2*p.baseSpecialAttack+p.IVspecialAttack)*p.level)/(110+p.level));
		p.specialDefense	=(int) Math.floor(((2*p.baseSpecialDefense+p.IVspecialDefense)*p.level)/(110+p.level));
		p.speed				=(int) Math.floor(((2*p.baseSpeed+p.IVspeed)*p.level)/(110+p.level));
	}
	public void levelUp() {
		level += 1;
		calculateStats(this);
	}
	public Pokemon giveItem(Item i){
		item = i;
		return this;
	}
}
