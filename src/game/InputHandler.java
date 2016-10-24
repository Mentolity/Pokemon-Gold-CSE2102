package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener{
	
	private Key lastPressed;
	
	public InputHandler(Game game){
		game.addKeyListener(this);
	}
	
	public class Key{
		private boolean pressed = false;
		private int ticksPressed = 0;
		public boolean check = true;
		public boolean isPressed(){
			if(pressed){
				ticksPressed++;
				lastPressed = this;
			}else{
				ticksPressed = 0;
			}
			
			return pressed;
		}		
		public void toggle(boolean isPressed){
			pressed = isPressed;
		}
		public int ticksPressed(){
			return ticksPressed;
		}
		public boolean getCheck(){
			return check;
		}
	}
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key enter = new Key();
	public Key z =  new Key();
	
	public Key debug = new Key(); //posts debug information
	
	
	public void keyPressed(KeyEvent e){
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_ENTER){
			enter.check = false;
			enter.toggle(true);
		}
		if(keycode == KeyEvent.VK_Z){
			z.toggle(true);
		}
		toggleKey(keycode, true);
	}
	public void keyReleased(KeyEvent e){
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_ENTER){
			enter.check = true;
			enter.toggle(false);
		}
		if(keycode == KeyEvent.VK_Z){
			z.toggle(false);
		}
		toggleKey(keycode, false);
	}
	public void keyTyped(KeyEvent e){
	
	}
	
	public void toggleKey(int keyCode, boolean isPressed){ //WASD controls for inputs
		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
			up.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
			down.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
			left.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
			right.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_P){
			debug.toggle(isPressed);
		}
	}
	
	public Key getLastPressed(){
		return lastPressed;
	}

}
