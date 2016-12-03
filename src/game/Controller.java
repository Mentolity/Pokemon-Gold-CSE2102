package game;

import save.Player;
import save.Save;
import maps.Door;
import maps.InteractableObject;
import menu.MainMenu;
import menu.Menu;
import game.Audio.audioFormat;
import gfx.DialogBox;
import gfx.PlayerCharacter;
import gfx.Screen;
import gfx.WhiteSpace;

public class Controller {
	public Player player;
	public Menu menu;
	public PlayerCharacter mc = new PlayerCharacter("/mcSpriteSheet.png");
	public InteractableObject interactableObject;
	
	public Controller(Save save){
		player = save.user;
		menu = new MainMenu(player);
	}
	
	public void tick(Game game, Screen screen){
		if(!game.map.isTransitioning())
			updatePlayerCharacter(game, screen);
		
		//check if you're on a door and if so go to that map
		Door d = game.map.onDoor(mc); 
		if(d != null && !game.map.isTransitioning()){
			Audio door = new Audio (AudioInit.effectPaths.get(2), Audio.audioFormat.EFFECT);
			door.start();
			
			screen.xOffset = d.getxInitPos();
			screen.yOffset = d.getyInitPos();
			
			game.map = d.getMap();
			game.map.setTransitioning();
			
			game.map.switchSongMap(game, screen);
		}
		
		if(interactableObject != null){
			if(interactableObject.getDialogBox().shouldClose()){
				interactableObject.getDialogBox().resetDialogBox();
				interactableObject = null;
				
			}
				
			if(game.input.z.isPressed() && game.input.z.ticksPressed() <= 1)
				interactableObject.getDialogBox().NextLine();			
		}
		
		//debug info bound to 'P'
		if(game.input.debug.isPressed() && game.input.debug.ticksPressed() <= 1){
			System.out.println("PC Position: " + mc.getxPos() + ", " + mc.getyPos());
			System.out.println("Screen Position: " + screen.xOffset + ", " + screen.yOffset);
		}
	}
	
	private void updatePlayerCharacter(Game game, Screen screen){
		mc.setyPos(screen.yOffset + mc.yCenter);
		mc.setxPos(screen.xOffset + mc.xCenter);	
		
		if(game.input.enter.isPressed() && game.input.enter.ticksPressed()<=1){
				if(!menu.isOpen()){
					menu.updateCursor();
					menu.open();
				}else{
					Menu opt = menu;
					menu = menu.goUp();
					if(menu!=null) {
						menu.updateCursor();
					}else{
						menu = opt;
						menu.close();
					}	
				}
		}		
		if(menu.isOpen()){
			menu.navigate(game.input);
			if(menu.next!=null){
				Menu m = menu.next;
				menu.next = null;
				menu = m;
			}
		}else if(interactableObject != null){
			if(!interactableObject.getDialogBox().shouldClose())
				return;
		}else if(game.input.z.isPressed() && game.input.z.ticksPressed() <= 1){
			interactableObject = mc.interact(screen, game.map);
		}else{
			mc.walk(game.input, screen, game.map);
		}
	}
}




















