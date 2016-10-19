package menu;

import game.InputHandler;
import gfx.Screen;

public abstract class Menu{
	public Menu last;
	public Menu next;
	public Option options[];
	protected Text texts[];
	protected Textbox boxes[];
	protected WhiteSpace white[];
	public Cursor cursor;
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
	public void render(Screen screen){
		if(isOpen){
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

