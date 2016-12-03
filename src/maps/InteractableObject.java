package maps;

import gfx.DialogBox;

public class InteractableObject{
	private int xPos;
	private int yPos;
	private DialogBox db;
	
	public InteractableObject(int x, int y){
		xPos = x;
		yPos = y;
		db = null;
	}
	
	public InteractableObject(int x, int y, String[] dialog){
		xPos = x;
		yPos = y;
		db = new DialogBox(dialog);
	}
	
	public int getxPos(){
		return xPos;
	}
	
	public int getyPos(){
		return yPos;
	}
	
	public DialogBox getDialogBox(){
		return db;
	}
}
