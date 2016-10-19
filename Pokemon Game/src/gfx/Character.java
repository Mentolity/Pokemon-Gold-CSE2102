package gfx;

public class Character {

	int direction = 1; //1Up,2Left,3Down,4Right
	//Should probably use enums but lazy
	
	String Path;
	SpriteSheet mcSpriteSheet;
	
	protected int xPos = 0;
	protected int yPos = 0;
	
	public Character(String spritePath){
		mcSpriteSheet = new SpriteSheet(spritePath);
	}
	
	public int getxPos(){
		return xPos;
	}

	public int getyPos(){
		return yPos;
	}
	public void setxPos(int x){
		xPos = x;
	}
	
	public void setyPos(int y){
		yPos = y;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public void setDirection(int dir){
		direction = dir;
	}
}
