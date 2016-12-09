package maps;

import gfx.Map;

public class NewBarkTownMap5 extends Map{
	public NewBarkTownMap5(Map parent) {
		super("/House1.png", "/House1PointMap.png");
		doors.add(new Door(48, 144, parent, 5584, 3584));
		doors.add(new Door(64, 144, parent, 5584, 3584));
		
		interactableObjects.add(new InteractableObject(16, 32, new String[]{"POKeMON magazines.", "POKeMON  PAL,", "POKeMON HANDBOOK,", "POKeMON GRAPH"}));
		interactableObjects.add(new InteractableObject(32, 32, new String[]{"POKeMON magazines.", "POKeMON  PAL,", "POKeMON HANDBOOK,", "POKeMON GRAPH"}));
		interactableObjects.add(new InteractableObject(48, 32, new String[]{"It's a TV."}));
		interactableObjects.add(new InteractableObject(64, 16, new String[]{"It's the TOWN MAP."}));
		interactableObjects.add(new InteractableObject(96, 16, new String[]{"My reflection!", "Lookin' good!"}));
	}
}
