package gfx;

import java.util.Arrays;

public class Text extends StaticImage{
	public static int template[] = new SpriteSheet("/characters.png").getPixels();
	public Text(String s){
		height = 8;
		init(s);
	}
	public Text(String s, int xp, int yp){
		height = 8;
		xPos = xp;
		yPos = yp;
		init(s);
	}
	public void init(String s){
		width = 8*s.length(); //length in pixels
		pixels = new int[height*width];
		for(int n=0;n<s.length();n++){
			int z = (int)s.charAt(n);
			if(z<32 || z>126){
				Arrays.fill(pixels,0xffffff);
				break;
			}
			int xPos = (z-1)%32;
			int yPos;
			if(z<65) yPos = 0;
			else if(z<97) yPos = 1;
			else yPos = 2;
			for(int y=0;y<height;y++){
				for(int x=(n*8);x<((n*8)+8);x++){
					if(z==32) pixels[x + y * width] = template[(248+(x%8)) + ((16+y)*256)];
					else pixels[x + y * width] = template[(xPos*8)+(x%8) + (((yPos*8)+y)*256)];
				}
			}
		}
	}
}
