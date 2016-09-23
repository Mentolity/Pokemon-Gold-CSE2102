package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	String mapPath;
	String mapPointPath;

	int width;
	int height;
	
	private int[] mPixels;
	private int[] mpPixels;
	
	private int[] gridPosition;
	public Map (String mp, String mpp){
		BufferedImage image;
		
		mapPath = mp;
		mapPointPath = mpp;
		
		
		try {
			image = ImageIO.read(Map.class.getResourceAsStream(mapPath));
			width = image.getWidth();
			height = image.getHeight();
			mPixels = image.getRGB(0, 0, width, height, null, 0, width);
			
			image = ImageIO.read(Map.class.getResourceAsStream(mapPointPath));
			mpPixels = image.getRGB(0, 0, width, height, null, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		gridPosition = new int[(width/16)*(height/16)];

	}
	
	public boolean isUpPassable(PlayerCharacter mc){
		return isPassable(mc, 0, -16);
	}
	
	public boolean isDownPassable(PlayerCharacter mc){
		return isPassable(mc, 0, 16);
	}
	
	public boolean isLeftPassable(PlayerCharacter mc){
		return isPassable(mc, -16, 0);
	}
	
	public boolean isRightPassable(PlayerCharacter mc){
		return isPassable(mc, 16, 0);
	}
	
	private boolean isPassable(PlayerCharacter mc, int xDir, int yDir){
		int topLeftPixel = mpPixels[(mc.getxPos()+xDir + ((mc.getyPos()+yDir)*width))] & 0xffffff;
		int topRightPixel = mpPixels[(mc.getxPos()+xDir+15 + ((mc.getyPos()+yDir)*width))] & 0xffffff;
		int bottomLeftPixel = mpPixels[(mc.getxPos()+xDir + ((mc.getyPos()+yDir+15)*width))] & 0xffffff;
		int bottomRightPixel = mpPixels[(mc.getxPos()+xDir+15 + ((mc.getyPos()+yDir+15)*width))] & 0xffffff;
		
		boolean movingUp = (xDir == 0 && yDir == -16);
		boolean movingDown = (xDir == 0 && yDir == 16);
		boolean movingLeft = (xDir == -16 && yDir == 0);
		boolean movingRight = (xDir == 16 && yDir == 0);
		
		switch (topLeftPixel){
			case 0x12ff00: //Trees_GREEN
				return false;
			case 0x00fffc: //Water_BLUE
				return false;
			case 0xff9000: //ledge_ORANGE
				if (movingLeft) //if the the top left is orange then the only time this is pass-able is if the mc is moving left
					return true;
				else
					return false;
			case 0xf6ff00: //ledge_YELLOW
				if (movingDown && bottomRightPixel == 0xff9000)
					return true;
				if (movingRight && bottomRightPixel == 0xff9000)
					return true;
				
				return false;
					
			default:
				return true;
		}

	}
	
	
	public int[] getPixels(){
		return mPixels;
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
