package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	public String path;
	private int width;
	private int height;
	
	private int[] pixels;
	
	public SpriteSheet(String path){
		BufferedImage image = null; //buffers the image with the buffered image class
		//loads the image
		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//the image can sometimes be null and returns just in case the catch above fails
		if(image == null){
			return;
		}
		 //initializes the class variables for this instance
		this.path = path;
		this.width = image.getWidth();
		this.height = image.getHeight();
		
		//sets the pixel variables
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
	}
	
	public int[] getPixels(){
		return pixels;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
}
