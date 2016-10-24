package menu;

import pokemon.Pokemon;
import gfx.Health;
import gfx.Screen;
import gfx.Text;
import gfx.WhiteSpace;

public class PokemonOption extends Option{
	public Pokemon pokemon;
	public PokemonOptionTemplate template;
	public Text name;
	public Text status;
	public Health health;
	public WhiteSpace cover;
	public PokemonOption(Pokemon p){
		pokemon = p;
		template = new PokemonOptionTemplate();
		name = new Text(p.name);
		if(p.health==p.maxHealth) health = new Health(100);
		else if(p.maxHealth==100) health = new Health(p.health);
		else if(p.health!=0){
			double h = p.health;
			double mH = p.maxHealth;
			health = new Health((int) ((h/mH)*100));
		}
		if(p.status!=null) status = new Text(p.status.text);
		if(p.item==null){
			cover = new WhiteSpace(12, 18);
		}
	}
	
	public Menu select() {
		// TODO Auto-generated method stub
		return null;
	}
	public void render(Screen screen) {
		screen.renderStaticImage(template);
		screen.renderStaticImage(name);
		if(health!=null) screen.renderStaticImage(health);
		if(status!=null) screen.renderStaticImage(status);
		if(cover!=null) screen.renderStaticImage(cover);
	}
	public Option setPos(int x, int y) {
		template.setPos(x, y);
		name.setPos(x, y);
		if(health!=null) health.setPos(x+37, y+11);
		if(status!=null) status.setPos(x, y+9);
		if(cover!=null) cover.setPos(x+139, y);
		return this;
	}

}
