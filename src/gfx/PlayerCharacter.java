package gfx;

import game.InputHandler;
import game.InputHandler.Key;

public class PlayerCharacter extends Character{
	public final int xCenter = 16*4;
	public final int yCenter = 16*4;
	private int renderX;
	private int renderY;
	
	int spriteSize = 16;
	
	private boolean isWalking = false;
	private int ticksWalked = 0;
	private int turnDelay = 7;
	private boolean flag = false; //used to alternate up/down walking sprites
			
	
	public PlayerCharacter(String spritePath){
		super(spritePath);
	}
	
	public int getRenderX(){
		return renderX;
	}
	public int getRenderY(){
		return renderY;
	}
	
	public void walk(InputHandler input, Screen screen, Map map){
		//Moves the pc smoothly to the next tile over the length of 16ticks
		if(isWalking){
			if(ticksWalked != 16){
				if(input.getLastPressed() == input.up){
					screen.yOffset--;
					ticksWalked++;
					return;
				}
				if(input.getLastPressed() == input.down){
					screen.yOffset++;
					ticksWalked++;
					return;
				}
				if(input.getLastPressed() == input.left){
					screen.xOffset--;
					ticksWalked++;
					return;
				}
				if(input.getLastPressed() == input.right){
					screen.xOffset++;
					ticksWalked++;
					return;
				}
				
			}else{
				isWalking = false;
			}
		}
		
		//Bug with holding multiple keys at once allows u to phase through walls. Need fix.
		//Logic for turning w/o moving and for moving to the next tile
		move(input.left, 2, input.up, input.down, input.right, map);
		move(input.right, 4, input.up, input.down, input.left, map);
		move(input.up, 1, input.down, input.left, input.right, map);
		move(input.down, 3, input.up, input.left, input.right, map);
	}
	
	private void move(Key check, int dir, Key k1, Key k2, Key k3, Map map){
		//if multiple keys are pressed at the same time use the one that has been held the longest
		if(check.ticksPressed() < k1.ticksPressed() || check.ticksPressed() < k2.ticksPressed() || check.ticksPressed() < k3.ticksPressed())
			return;
			
		//if a key is pressed walk in that direction
		if(check.isPressed()){
			direction = dir;
			if(check.ticksPressed() >= turnDelay){
				if(map.isPassable(dir, this)){
					isWalking = true;
					flag = !flag;
					ticksWalked = 0;
				}
			}
		}
	}
	
	public void render(Screen screen){
		//logic for rendering the correct sprites based on direction and position in walk cycle
		if(isWalking){
			switch (direction){
			case 1:
				if(ticksWalked < 8){
					if (flag){
						renderBackWalk1(screen);
					}else{
						renderBackWalk2(screen);
					}
						
				}else if(ticksWalked <= 16){
					renderBack(screen);
				}
				break;
			case 2:
				
				if(ticksWalked < 8){
					renderLeftProfileWalk(screen);
				}else if(ticksWalked <= 16){
					renderLeftProfile(screen);
				}
				break;
			case 3:
				if(ticksWalked < 8){
					if (flag){
						renderForwardWalk1(screen);
					}else{
						renderForwardWalk2(screen);
					}	
				}else if(ticksWalked <= 16){
					renderForward(screen);
				}
				break;
			case 4:
				if(ticksWalked < 8){
					renderRightProfileWalk(screen);
				}else if(ticksWalked <= 16){
					renderRightProfile(screen);
				}
				break;
			}
		}else{
			switch (direction){
			case 1:
				renderBack(screen);
				break;
			case 2:
				renderLeftProfile(screen);
				break;
			case 3:
				renderForward(screen);
				break;
			case 4:
				renderRightProfile(screen);
				break;
			}
			
		}
	}
	
	private void renderForward(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 0, 0, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderLeftProfile(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 1, 0, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderBack(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 2, 0, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderRightProfile(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 3, 0, spriteSize, spriteSize, mcSpriteSheet);
	}	

	private void renderForwardWalk1(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 0, 1, spriteSize, spriteSize, mcSpriteSheet);
	}

	private void renderForwardWalk2(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 0, 2, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderLeftProfileWalk(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 1, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderBackWalk1(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 2, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderBackWalk2(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 1, 2, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderRightProfileWalk(Screen screen){
		updateRenderPos(screen);
		screen.renderSprite(renderX, renderY, 3, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void updateRenderPos(Screen screen){
		renderX = screen.xOffset+xCenter+1;
		renderY = screen.yOffset+yCenter-4;
	}
	

	
}
