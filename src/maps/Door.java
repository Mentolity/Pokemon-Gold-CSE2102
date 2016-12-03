package maps;

import gfx.Map;

public class Door{
	private int xPos;
	private int yPos;
	private Map map;
	
	private int xInitPos;
	private int yInitPos;
	
	//x,y is PC Position for the entrance and xInit,yInit is the screen position upon load
	public Door(int x, int y, Map m, int xInit, int yInit){ 
		xPos = x;
		yPos = y;
		map = m;
		xInitPos = xInit;
		yInitPos = yInit;
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public Map getMap() {
		return map;
	}
	
	public int getxInitPos(){
		return xInitPos;
	}
	public int getyInitPos(){
		return yInitPos;
	}

}