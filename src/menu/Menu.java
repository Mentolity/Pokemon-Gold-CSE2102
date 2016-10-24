package menu;

import game.InputHandler;
import gfx.Cursor;
import gfx.Screen;
import gfx.StaticImage;
import gfx.Text;
import gfx.Textbox;
import gfx.WhiteSpace;

public abstract class Menu{
	public Menu last;
	public Menu next;
	public Option options[];
	protected Text texts[];
	protected Textbox boxes[];
	protected WhiteSpace white[];
	protected StaticImage template;
	public static Cursor cursor = new Cursor(0,0);
	public int loc = 0;
	protected boolean isOpen;
	public boolean isOpen(){
		return isOpen;
	}
	public Menu open(){
		isOpen = true;
		return this;
	}
	public Menu close(){
		loc = 0;
		isOpen = false;
		return this;
	}
	public Menu goUp(){
		this.close();
		if(last!=null){
			last.open();
			return last;
		}
		else return null;
	}
	public Menu goIn(){
		if(options[loc]==null) return null; 
		else{
			this.close();
			return options[loc].select();
		}	
	}
	public abstract void navigate(InputHandler input);
	public abstract void updateCursor();
	public void render(Screen screen){
		if(isOpen){
			if(template!=null) screen.renderStaticImage(template);
			if(boxes!=null) for(Textbox box : boxes){
				if(box!=null) screen.renderStaticImage(box);
			}
			if(white!=null) for(WhiteSpace space : white){
				if(space!=null) screen.renderStaticImage(space);
			}
			if(options!=null) for(Option option : options){
				if(option!=null) option.render(screen);
			}
			if(texts!=null) for(Text text : texts){
				if(text!=null) screen.renderStaticImage(text);
			}
			if(cursor!=null) screen.renderStaticImage(cursor);
		}
	}	
}

