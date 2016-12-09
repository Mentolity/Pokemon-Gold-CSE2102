package maps;

import gfx.DialogBox;

public class ObjectDialogBox extends DialogBox{
	private int xPos;
	private int yPos;
	
	public ObjectDialogBox(String[] dialog, int x, int y) {
		super(dialog);
		xPos = x;
		yPos = y;
	}

}
