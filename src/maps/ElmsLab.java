package maps;

import gfx.Map;

public class ElmsLab extends Map{
	public ElmsLab(Map parent) {
		super("/ElmsLabMap.png", "/ElmsLabPointMap.png");
		doors.add(new Door(80, 208, parent, 5632, 3456));
		doors.add(new Door(96, 208, parent, 5632, 3456));
		
		interactableObjects.add(new InteractableObject(112, 32, new String[]{"It's full of", "difficult books."}));
		interactableObjects.add(new InteractableObject(128, 32, new String[]{"It's full of", "difficult books."}));
		interactableObjects.add(new InteractableObject(144, 32, new String[]{"It's full of", "difficult books."}));
		interactableObjects.add(new InteractableObject(160, 32, new String[]{"It's full of", "difficult books."}));
		
		
		interactableObjects.add(new InteractableObject(112, 128, new String[]{"It's full of", "difficult books."}));
		interactableObjects.add(new InteractableObject(128, 128, new String[]{"It's full of", "difficult books."}));
		interactableObjects.add(new InteractableObject(144, 128, new String[]{"It's full of", "difficult books."}));
		interactableObjects.add(new InteractableObject(160, 128, new String[]{"It's full of", "difficult books."}));
		
		
		interactableObjects.add(new InteractableObject(16, 128, new String[]{"Travel Tip 1:", "", "*", "Press START to", "open the MENU."}));
		interactableObjects.add(new InteractableObject(32, 128, new String[]{"Travel Tip 2:", "", "*", "Record your trip", "with SAVE."}));
		interactableObjects.add(new InteractableObject(48, 128, new String[]{"Travel Tip 3:", "", "*", "Open your PACK and", "press SELECT to", "move items."}));
		interactableObjects.add(new InteractableObject(64, 128, new String[]{"Travel Tip 4:", "", "*", "Check your POKeMON", "moves. Press the", "*", "A Button to switch",  "moves."}));
		

		interactableObjects.add(new InteractableObject(80, 16, new String[]{"My reflection!", "Lookin' good!"}));
		interactableObjects.add(new InteractableObject(96, 16, new String[]{"The window's open.", "", "*", "A pleasant breeze", "is blowing in."}));
		
		interactableObjects.add(new InteractableObject(160, 64, new String[]{"The wrapper from", "the snack PROF.ELM", "ate is in there."}));
	}
}
