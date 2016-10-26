package pokemon;

public class Squirtle extends Pokemon {
	public Squirtle(int l) {
		name				= "Squirtle";
		ID					= 7;
		t					= Type.WATER;

		//Base stats
		level				= l;	
		baseMaxHP			= 44;
		baseAttack			= 48;
		baseDefense			= 65;
		baseSpecialAttack	= 50;
		baseSpecialDefense	= 64;
		baseSpeed			= 43;
		
		//IVs
		IVmaxHP				= (int)Math.ceil((Math.random()*15));
		IVattack			= (int)Math.ceil((Math.random()*15));
		IVdefense			= (int)Math.ceil((Math.random()*15));
		IVspecialAttack		= (int)Math.ceil((Math.random()*15));
		IVspecialDefense	= (int)Math.ceil((Math.random()*15));
		IVspeed				= (int)Math.ceil((Math.random()*15));
		
		calculateStats(this);
	}
}