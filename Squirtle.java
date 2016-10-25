package pokemon;

public class Squirtle extends Pokemon {
	public Squirtle(int level) {
		this.ID					= 7;
		this.t					= Type.WATER;

		//Base stats
		this.baseMaxHP			= 44;
		this.baseAttack			= 48;
		this.baseDefense		= 65;
		this.baseSpecialAttack	= 50;
		this.baseSpecialDefense	= 64;
		this.baseSpeed			= 43;
		
		//IVs
		this.IVmaxHP			= (int)Math.ceil((Math.random()*15));
		this.IVattack			= (int)Math.ceil((Math.random()*15));
		this.IVdefense			= (int)Math.ceil((Math.random()*15));
		this.IVspecialAttack	= (int)Math.ceil((Math.random()*15));
		this.IVspecialDefense	= (int)Math.ceil((Math.random()*15));
		this.IVspeed			= (int)Math.ceil((Math.random()*15));
		
		calculateStats(this);
	}
}