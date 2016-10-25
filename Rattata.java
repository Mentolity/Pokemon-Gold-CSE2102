package pokemon;

public class Rattata extends Pokemon {
	public Rattata(int level) {
		this.ID				= 19;
		
		//Base stats
		this.maxHP			= 30;
		this.currentHP		= maxHP;
		this.attack			= 56;
		this.defense		= 35;
		this.specialAttack	= 25;
		this.specialDefense	= 35;
		this.speed			= 72;
		
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
