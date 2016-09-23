package gfx;

public class Fonts {
	private static String chars = ""+"ABCDEFGHIJKLMNOPQRSTUVWXYZ      "+"0123456789.,:;'\"!?$%()-=+/      ";
	
	public static void render(String msg, Screen screen, int x, int y){
		msg = msg.toUpperCase();
		for(int i=0; i<msg.length(); i++){
			int charIndex = chars.indexOf(msg.charAt(i)); //where we are in the array
			//if(charIndex>=0) screen.renderSprite(x+(i*8), y, charIndex + 30 * 32);
		}
	}
}
