package menu;

import game.AudioInit;
import game.Effect;
import game.Game;
import save.Save;
import game.InputHandler;
import game.Music;
import gfx.Textbox;
import gfx.WhiteSpace;

public class TitleMenu extends Menu {
	public int size;
	public TitleMenu(Save[] save){
		cursor.setPos(8, 9);
		options = new Option[save.length+1];
		for(int x=0;x<save.length;x++) options[x] = new SaveOption(save[x]).setPos(16, (x*9)+9);
		options[save.length] = new NewGameOption();
		size = options.length;
		boxes = new Textbox[]{
				new Textbox(0, 0, 10, 18)
		};
		white = new WhiteSpace[]{
				new WhiteSpace(0, 0, 160, 144)
		};
		
	}
	public void navigate(InputHandler input) {
		if(input.up.isPressed()){
			if(input.up.ticksPressed()<=1){
				if(loc==0) loc = size;
				else loc--;
				cursor.setPos(8,(loc*9)+9);
			}	
		}else if(input.down.isPressed()){
			if(input.down.ticksPressed()<=1){
				if(loc==size) loc = 0;
				else loc++;
				cursor.setPos(8,(loc*9)+9);
			}	
		}
		if(input.z.isPressed()){
			if(input.z.ticksPressed()>1)
			{
				Effect menuSelect = new Effect (AudioInit.effectPaths.get(4));
				menuSelect.start();
				close();
			}
		}
	}
	public Menu close(){
		isOpen = false;
		Music.stopClip(AudioInit.titleScreen);
		Music.startClip(AudioInit.cherryGrove);
		return this;
	}
	public void updateCursor() {
		loc = 0;
		cursor.setPos(8, 9);
	}

}
