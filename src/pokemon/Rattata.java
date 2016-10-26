package pokemon;

public class Rattata extends Pokemon {
	public Rattata(int l) {
		name 				= "Rattata";
		ID					= 19;
		t					= Type.NORMAL; 
		
		//Base stats
		level				= l; 
		maxHP				= 30;
		attack				= 56;
		defense				= 35;
		specialAttack		= 25;
		specialDefense		= 35;
		speed				= 72;
		
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
