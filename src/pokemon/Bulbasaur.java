package pokemon;

public class Bulbasaur extends Pokemon {
	public Bulbasaur(int l) {
		name 				= "Bulbasaur";
		ID					= 1;
		t					= Type.GRASS;

		//Base stats
		level 				= l;
		baseMaxHP			= 45;
		baseAttack			= 49;
		baseDefense			= 49;
		baseSpecialAttack	= 65;
		baseSpecialDefense	= 65;
		baseSpeed			= 45;
		
		//IVs
		IVmaxHP				= (int)Math.ceil((Math.random()*31));
		IVattack			= (int)Math.ceil((Math.random()*31));
		IVdefense			= (int)Math.ceil((Math.random()*31));
		IVspecialAttack		= (int)Math.ceil((Math.random()*31));
		IVspecialDefense	= (int)Math.ceil((Math.random()*31));
		IVspeed				= (int)Math.ceil((Math.random()*31));
		
		calculateStats(this);
	}
}
