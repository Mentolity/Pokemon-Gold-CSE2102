package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.Game;
import maps.Doors;

public class Map {
	String mapPath;
	String mapPointPath;

	int width;
	int height;
	
	private int[] mPixels;
	private int[] mpPixels;
	
	Audio bump = new Audio ("./res/bump.wav", audioFormat.EFFECT);
	private long tickLength = bump.getEffectTickLength();
	private long ticks = 0;
	
	protected ArrayList<Doors> doors = new ArrayList<Doors>();
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
	}
	
	public boolean isPassable(int direction, PlayerCharacter mc){
		switch (direction){
			case 1:
				return isUpPassable(mc);
			case 2:
				return isLeftPassable(mc);
			case 3: 
				return isDownPassable(mc);
			case 4:
				return isRightPassable(mc);
			default:
				return false;
		}
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
	
	public Doors onDoor(PlayerCharacter mc){
		for(Doors d : doors){
			if(d.getxPos() == mc.getxPos() && d.getyPos() == mc.getyPos()){
				return d;
			}
		}
		return null;
	}
	
	private boolean isPassable(PlayerCharacter mc, int xDir, int yDir){
		try{
			int topLeftPixel = mpPixels[(mc.getxPos()+xDir + ((mc.getyPos()+yDir)*width))] & 0xffffff;
			//int topRightPixel = mpPixels[(mc.getxPos()+xDir+15 + ((mc.getyPos()+yDir)*width))] & 0xffffff;
			//int bottomLeftPixel = mpPixels[(mc.getxPos()+xDir + ((mc.getyPos()+yDir+15)*width))] & 0xffffff;
			int bottomRightPixel = mpPixels[(mc.getxPos()+xDir+15 + ((mc.getyPos()+yDir+15)*width))] & 0xffffff;
			
			//boolean movingUp = (xDir == 0 && yDir == -16);
			boolean movingDown = (xDir == 0 && yDir == 16);
			boolean movingLeft = (xDir == -16 && yDir == 0);
			boolean movingRight = (xDir == 16 && yDir == 0);
			
			
			
			if (topLeftPixel == 0x12ff00 || topLeftPixel == 0x00fffc || topLeftPixel == 0xf6ff00)
			{
				if (ticks == 0 || (ticks % (bump.getEffectTickLength())) == 0)
				{
					Audio bump = new Audio(Game.effectPaths.get(1), audioFormat.EFFECT);
					bump.start();
				}
			 ticks++;
			}
			
			switch (topLeftPixel){
				case 0x12ff00: //Trees_GREEN
					return false;
				case 0x0F00FF: //Water
					return false;
				case 0xFFFF00: //Water
					return false;
				case 0x00FFFC: //Water_Ledge
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
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	private boolean transitioning = false;
	private int transitionCounterEndPoint = 33;					//11 ticks fade-out, 11 ticks white, 11 ticks fade-in 
	private int transitionCounter = transitionCounterEndPoint;
	private int animationTickCounter = 0;
	private int animationTickPosition = 0;
	private final int animationTimer = 8;
	public void render(Screen screen, PlayerCharacter mc){
		//if in a transition phases render that animation
		
		if(transitioning && transitionCounter > 0){
			renderMapTransition(screen, mc);			
			transitionCounter--;
		//else render the map and mc normally
		}else{
			transitionCounter = transitionCounterEndPoint;
			transitioning = false;
			screen.renderMap(this);
			mc.render(screen);
		}
		
		animationTickCounter++;
		if(animationTickCounter < 5*animationTimer){
			animationTickPosition = 0;
		}else if(animationTickCounter < 6*animationTimer){
			animationTickPosition = 1;
		}else if(animationTickCounter < 11*animationTimer){
			animationTickPosition = 2;
		}else if(animationTickCounter < 16*animationTimer){
			animationTickPosition = 3;
		}else if(animationTickCounter < 21*animationTimer){
			animationTickPosition = 2;
		}else if(animationTickCounter < 22*animationTimer){
			animationTickPosition = 1;
		}else{
			animationTickCounter = 0;
		}
		//System.out.println(animationTickCounter);
	}
	
	public int getAnimationTickPosition(){
		return animationTickPosition;
	}
	
	
	public void setTransitioning(){
		transitioning = true;
	}
	public boolean isTransitioning(){
		return transitioning;
	}
	
	
	public void renderMapTransition(Screen screen, PlayerCharacter mc){
		int argb, r, g, b, rPlus, gPlus, bPlus;
		int transitionCounter;
		int target, rTarget, gTarget, bTarget;
		int xPos = screen.xOffset;
		int yPos = screen.yOffset;
		
		//iterate over the whole screen
		if(this.transitionCounter > (2*transitionCounterEndPoint)/3){
			transitionCounter = this.transitionCounter - (2*transitionCounterEndPoint)/3;
			for(int y=0; y<screen.height; y++){
				for(int x=0; x<screen.width; x++){
					argb = screen.pixels[(x) + (y) * screen.width];		//got argb of current pixel
					r = (argb>>16)&0xFF;								//r of argb
					g = (argb>>8)&0xFF;									//g of argb
					b = (argb>>0)&0xFF;									//b of argb
					
					rPlus = (255-r)/transitionCounter;					//increment values towards white
					gPlus = (255-g)/transitionCounter;
					bPlus = (255-b)/transitionCounter;
					
					
					if(rPlus == 0 && r < 255)							//if almost white just jump there
						rPlus = (255-r);
					if(gPlus == 0 && g < 255)
						gPlus = (255-g);
					if(bPlus == 0 && b < 255)
						bPlus = (255-b);
	
					if(r < 255)											//if already white don't overflow, else increment up towards white
						argb += (rPlus<<16);
					
					if(g < 255)
						argb += (gPlus<<8);
		
					if(b < 255)
						argb += bPlus;	
					
					screen.pixels[(x) + (y) * screen.width] = argb;		//update pixel to new argb value
				}
			}
		}else if(this.transitionCounter < (transitionCounterEndPoint)/3){	//Fade-in to the new map					
			//this is current map so use mPixels for target colors
			transitionCounter = this.transitionCounter;
			
			for(int y=0; y<screen.height; y++){
				for(int x=0; x<screen.width; x++){
					argb = screen.pixels[(x) + ((y) * screen.width)];		//get argb of current pixel
					r = (argb>>16)&0xFF;								//r of argb
					g = (argb>>8)&0xFF;									//g of argb
					b = (argb>>0)&0xFF;									//b of argb
					
					
					//If where outside of the defined range of the map set target to 0
					if((x + xPos < 0 || x + xPos >= width) || (y + yPos < 0 || y + yPos >= height)){
						target = 0x000000;	
					}else{//else set the target to the pixel at the given point of the map
						target = mPixels[(x+xPos) + ((y+yPos)*width)];
					}		
					
					//rgb variables for target
					rTarget = (target>>16)&0xFF;
					gTarget = (target>>8)&0xFF;
					bTarget = (target>>0)&0xFF;
					
					
					rPlus = (rTarget-r)/transitionCounter;					//increment values towards target
					gPlus = (gTarget-g)/transitionCounter;
					bPlus = (bTarget-b)/transitionCounter;
					
					
					if(rPlus == 0 && r > rTarget)							//if almost to target jump there
						rPlus = (rTarget-r);
					if(gPlus == 0 && g > gTarget)
						gPlus = (gTarget-g);
					if(bPlus == 0 && b > bTarget)
						bPlus = (bTarget-b);
	
					if(r > rTarget)											//if already the at the don't overflow, else increment up towards the target
						argb += (rPlus<<16);
					
					if(g > gTarget)
						argb += (gPlus<<8);
		
					if(b > bTarget)
						argb += bPlus;	
					
					screen.pixels[(x) + (y) * screen.width] = argb;		//update pixel to new argb value
				}
			}
			mc.render(screen);				//render mc over fade-in
											//Should figure out a way to do this such that mc renders only once as opposed to every transition tick <1/3EndPoint
		}
				
	}
	
	public int[] getPixels(){
		return mPixels;
	}
	
	public int[] getPointPixels(){
		return mpPixels;
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public String getMapPath()
	{
		return mapPath;
	}
	
}
