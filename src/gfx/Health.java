package gfx;


public class Health extends StaticImage {
	public static int template[] = new SpriteSheet("/green.png").getPixels();
	public Health(int length){
		width = length;
		height = 5;
		init();
	}
	public void init(){
		pixels = new int[width*height];
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				pixels[x + y * width] = template[0];
			}
		}
	}
}
