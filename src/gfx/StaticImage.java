package gfx;

public abstract class StaticImage {
	public int width;
	public int height;
	public int xPos = 0;
	public int yPos = 0;
	public int pixels[];
	public StaticImage setPos(int x, int y){
		xPos = x;
		yPos = y;
		return this;
	}
	public void render(Screen screen){
		screen.renderStaticImage(this);
	}
}
