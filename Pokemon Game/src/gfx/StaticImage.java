package gfx;

public abstract class StaticImage {
	public int width;
	public int height;
	public int xPos = 0;
	public int yPos = 0;
	public int template[];
	public int pixels[];
	public void setPos(int x, int y){
		xPos = x;
		yPos = y;
	}
	public void render(Screen screen){
		screen.renderStaticImage(this);
	}
}
