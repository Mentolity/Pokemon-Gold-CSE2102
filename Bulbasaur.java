package pokemon;

public class Bulbasaur extends Pokemon {
	public Bulbasaur(int level) {
		this.ID					= 1;
		this.t					= Type.GRASS;

		//Base stats
		this.baseMaxHP			= 45;
		this.baseAttack			= 49;
		this.baseDefense		= 49;
		this.baseSpecialAttack	= 65;
		this.baseSpecialDefense	= 65;
		this.baseSpeed			= 45;
		
		//IVs
		this.IVmaxHP			= (int)Math.ceil((Math.random()*31));
		this.IVattack			= (int)Math.ceil((Math.random()*31));
		this.IVdefense			= (int)Math.ceil((Math.random()*31));
		this.IVspecialAttack	= (int)Math.ceil((Math.random()*31));
		this.IVspecialDefense	= (int)Math.ceil((Math.random()*31));
		this.IVspeed			= (int)Math.ceil((Math.random()*31));
		
		calculateStats(this);
	}
}
