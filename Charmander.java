package pokemon;

public class Charmander extends Pokemon {
	public Charmander(int level) {
		this.ID					= 4;
		this.t					= Type.FIRE;
		this.description		= "The flame on its tail shows the strength of its life force. If it is weak, the flame also burns weakly.";
		
		//Base stats
		this.baseMaxHP			= 39;
		this.baseAttack			= 52;
		this.baseDefense		= 43;
		this.baseSpecialAttack	= 60;
		this.baseSpecialDefense	= 50;
		this.baseSpeed			= 65;
		
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
