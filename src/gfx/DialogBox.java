package gfx;

import game.AudioInit;
import game.Effect;
import game.Game;

public class DialogBox {
	private final int MAXLINELENGTH = 18;
	private final int T1YPOS = 16*7;
	private final int T2YPOS = 16*8;
	
	Textbox textbox = new Textbox(0, 16*6, 20, 6);
	Text textLine1;
	Text textLine2;
	
	private int renderTimer = 0;
	
	private int t1StartPos = 0;
	private int t1EndPos = 0;
	private int t2StartPos = 0;
	private int t2EndPos= 0;
	
	private int index = 0;
	
	private boolean transitioning = false;
	private boolean close = false;
	
	private String[] dialog;
	
	public DialogBox(String[] dialog){
		this.dialog = dialog;
		

		textLine1 = new Text("", 8, T1YPOS);
		textLine2 = new Text("", 8, T2YPOS);
	}
	
	public void render(Screen screen){
		screen.renderStaticImage(textbox);
		screen.renderStaticImage(textLine1);
		screen.renderStaticImage(textLine2);
		renderTimer++;
		
		if(transitioning){
			transitionLogic();
		}
		if(renderTimer % 5 == 0){
			if((t1EndPos < dialog[index].length()) && ((t1EndPos - t1StartPos) < MAXLINELENGTH)){
				t1EndPos++;
				textLine1.init(dialog[index].substring(t1StartPos, t1EndPos));
			}else if(dialog.length != 1){ //if there isn't a 2nd line of dialog don't try to render it
				try{
					if((t2EndPos < dialog[index+1].length()) && ((t2EndPos - t2StartPos) < MAXLINELENGTH)){
						t2EndPos++;
						textLine2.init(dialog[index+1].substring(t2StartPos, t2EndPos));
					}
				}catch (Exception e){
					
				}
			}
		}
	}
	
	public void NextLine(){
		transitioning = true;
		renderTimer = 0;
	}
	
	private void transitionLogic(){
	 	Effect menuSelect = new Effect (AudioInit.effectPaths.get(4));
		//if the text hasn't finished rendering then auto-complete and finish transition
		if(t1EndPos < dialog[index].length() && dialog.length == 1){
			transitioning = false;
			t1EndPos = dialog[index].length()-1;
			return;
		}
		if(dialog.length != 1){
			if(t1EndPos < dialog[index].length() || t2EndPos < dialog[index+1].length()){
				transitioning = false;
				t1EndPos = dialog[index].length()-1;
				t2EndPos = dialog[index+1].length()-1;
				return;
			}
		}
		
		try{
			if(dialog[index+2].equals("*")){
				menuSelect.start();
				index += 3;
				t1StartPos = 0;
				t2StartPos = 0;
				t1EndPos = 0;
				t2EndPos = 0;
				textLine1.init("");
				textLine2.init("");
			 	transitioning = false;
			 	return;
			}
		}catch (Exception e){

		}
		
		//if there is only one element in the array of dialog theres nothing to transition and the next call should close the box
		if(dialog.length == 1){
			transitioning = false;
		 	close = true;
		 	return;
		}
		
		//if theres no more text don't tranisition and request for the box to be closed
		if(dialog.length-2 == index){
		 	transitioning = false;
		 	close = true;
		 	return;
		}
		
		//Run the dialog transition to the next line of text
		if(!dialog[index+1].equals("")){
			if(renderTimer == 1)
				menuSelect.start();
			
			if(renderTimer < 6){
				textLine1.setY(T1YPOS - 8);
				textLine2.setY(T2YPOS - 8);	
			}else if(renderTimer < 12){
				textLine1.init(dialog[index+1].substring(t2StartPos, t2EndPos));
				textLine2.init("");
				textLine1.setY(T1YPOS);
				textLine2.setY(T2YPOS);	
			}else if(dialog.length-1 != index){
			 	index++;
				t1StartPos = t2StartPos;
				t1EndPos = t2EndPos;
				t2StartPos = 0;
			 	t2EndPos= 0;
			 	transitioning = false;
			}
		}else{
			menuSelect.start();
			index += 2;
			t1StartPos = 0;
			t1EndPos = 0;
			t2StartPos = 0;
		 	t2EndPos= 0;
		 	textLine1.init("");
			textLine2.init("");
		 	transitioning = false;
		}
	}
	
	public boolean shouldClose(){
		return close;
	}
	
	public void resetDialogBox(){
		close = false;
		t1StartPos = 0;
		t1EndPos = 0;
		t2StartPos = 0;
		t2EndPos= 0;
		index = 0;
		textLine1 = new Text("", 8, T1YPOS);
		textLine2 = new Text("", 8, T2YPOS);
	}

}











