package gfx;


public class WhiteSpace extends StaticImage {
	public static int template[] = new SpriteSheet("/white.png").getPixels();
	public WhiteSpace(int x, int y, int w, int h){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		pixels = new int[height*width];
		init();
	}
	public WhiteSpace(int w, int h){
		width = w;
		height = h;
		pixels = new int[height*width];
		init();
	}
	public void init(){
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				pixels[x + y * width] = template[0];
			}
		}
	}
}
