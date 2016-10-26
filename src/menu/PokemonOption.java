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
	public Text level;
	public Health health;
	public WhiteSpace cover;
	public PokemonOption(Pokemon p){
		pokemon = p;
		template = new PokemonOptionTemplate();
		name = new Text(p.name);
		level = new Text("Lv"+Integer.toString(p.level));
		if(p.currentHP==p.maxHP) health = new Health(100);
		else if(p.maxHP==100) health = new Health(p.currentHP);
		else if(p.currentHP!=0){
			double h = p.currentHP;
			double mH = p.maxHP;
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
		screen.renderStaticImage(level);
		if(health!=null) screen.renderStaticImage(health);
		if(status!=null) screen.renderStaticImage(status);
		if(cover!=null) screen.renderStaticImage(cover);
	}
	public Option setPos(int x, int y) {
		template.setPos(x, y);
		name.setPos(x, y);
		level.setPos(x+99, y);
		if(health!=null) health.setPos(x+37, y+11);
		if(status!=null) status.setPos(x, y+9);
		if(cover!=null) cover.setPos(x+139, y);
		return this;
	}

}
