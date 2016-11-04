package pokemon;

public class Charmander extends Pokemon {
	public Charmander(int l) {
		name 				= "Charmander";
		ID					= 4;
		t					= Type.FIRE;
		description			= "The flame on its tail shows the strength of its life force. If it is weak, the flame also burns weakly.";
		
		//Base stats
		level				= l;	
		baseMaxHP			= 39;
		baseAttack			= 52;
		baseDefense			= 43;
		baseSpecialAttack	= 60;
		baseSpecialDefense	= 50;
		baseSpeed			= 65;
		
		//IVs
		IVmaxHP				= (int)Math.ceil((Math.random()*31));
		IVattack			= (int)Math.ceil((Math.random()*31));
		IVdefense			= (int)Math.ceil((Math.random()*31));
		IVspecialAttack		= (int)Math.ceil((Math.random()*31));
		IVspecialDefense	= (int)Math.ceil((Math.random()*31));
		IVspeed				= (int)Math.ceil((Math.random()*31));
		
		calculateStats(this);
	}

	public Charmander() {
		// TODO Auto-generated constructor stub
	}
}
