package gfx;

import game.Game;
import game.InputHandler;

public class PlayerCharacter extends Character{

	int renderX = Game.screen.xOffset+16*4;
	int renderY = Game.screen.yOffset+16*4;
	
	int spriteSize = 16;
	
	private boolean isWalking = false;
	private int ticksWalked = 0;
	private int turnDelay = 7;
	private boolean flag = false; //used to alternate up/down walking sprites
			
	
	public PlayerCharacter(String spritePath){
		super(spritePath);
	}
	
	public void walk(InputHandler input, Screen screen, Map map){
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
		if(input.up.isPressed()){
			direction = 1;
			if(input.up.ticksPressed() >= turnDelay){
				if(map.isUpPassable(this)){
					isWalking = true;
					flag = !flag;
					ticksWalked = 0;
				}
			}
		}
		if(input.down.isPressed()){
			direction = 3;
			if(input.down.ticksPressed() >= turnDelay){
				if(map.isDownPassable(this)){
					isWalking = true;
					flag = !flag;
					ticksWalked = 0;
				}
			}
		}
		if(input.left.isPressed()){
			direction = 2;
			if(input.left.ticksPressed() >= turnDelay){
				if(map.isLeftPassable(this)){
					isWalking = true;
					ticksWalked = 0;
				}
			}
		}
		if(input.right.isPressed()){
			direction = 4;
			if(input.right.ticksPressed() >= turnDelay){
				if(map.isRightPassable(this)){
					isWalking = true;
					ticksWalked = 0;
				}
			}
		}
	}
	
	public void render(){
		if(isWalking){
			switch (direction){
			case 1:
				if(ticksWalked < 8){
					if (flag){
						renderBackWalk1();
					}else{
						renderBackWalk2();
					}
						
				}else if(ticksWalked <= 16){
					renderBack();
				}
				break;
			case 2:
				
				if(ticksWalked < 8){
					renderLeftProfileWalk();
				}else if(ticksWalked <= 16){
					renderLeftProfile();
				}
				break;
			case 3:
				if(ticksWalked < 8){
					if (flag){
						renderForwardWalk1();
					}else{
						renderForwardWalk2();
					}	
				}else if(ticksWalked <= 16){
					renderForward();
				}
				break;
			case 4:
				if(ticksWalked < 8){
					renderRightProfileWalk();
				}else if(ticksWalked <= 16){
					renderRightProfile();
				}
				break;
			}
		}else{
			switch (direction){
			case 1:
				renderBack();
				break;
			case 2:
				renderLeftProfile();
				break;
			case 3:
				renderForward();
				break;
			case 4:
				renderRightProfile();
				break;
			}
			
		}
	}
	
	private void renderForward(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 0, 0, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderLeftProfile(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 1, 0, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderBack(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 2, 0, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderRightProfile(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 3, 0, spriteSize, spriteSize, mcSpriteSheet);
	}	
	
	
	private void renderForwardWalk1(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 0, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	private void renderForwardWalk2(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 0, 2, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderLeftProfileWalk(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 1, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderBackWalk1(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 2, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	private void renderBackWalk2(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 1, 2, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void renderRightProfileWalk(){
		updateRenderPos();
		Game.screen.renderSprite(renderX, renderY, 3, 1, spriteSize, spriteSize, mcSpriteSheet);
	}
	
	private void updateRenderPos(){
		renderX = Game.screen.xOffset+16*4;
		renderY = Game.screen.yOffset+16*4;
	}
	

	
}
