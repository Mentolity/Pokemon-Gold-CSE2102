package maps;

import gfx.Map;

public class CherryGroveCityMap4 extends Map{
	public CherryGroveCityMap4(Map parent) {
		super("/House1.png", "/House1PointMap.png");
		doors.add(new Door(48, 144, parent, 4208, 3520));
		doors.add(new Door(64, 144, parent, 4208, 3520));
		
		interactableObjects.add(new InteractableObject(16, 32, new String[]{"A whole collection", "of POKeMON picture", "books!"}));
		interactableObjects.add(new InteractableObject(32, 32, new String[]{"A whole collection", "of POKeMON picture", "books!"}));
		interactableObjects.add(new InteractableObject(48, 32, new String[]{"It's a TV."}));
		interactableObjects.add(new InteractableObject(64, 16, new String[]{"It's the TOWN MAP."}));
		interactableObjects.add(new InteractableObject(96, 16, new String[]{"It's "}));
	}
}
