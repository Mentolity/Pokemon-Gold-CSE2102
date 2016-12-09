package maps;

import gfx.Map;

public class HiroHouseUpperLevel extends Map{
	public HiroHouseUpperLevel(Map parent) {
		super("/HiroHouseUpperLevelMap.png", "/HiroHouseUpperLevelPointMap.png");
		doors.add(new Door(128, 16, parent, 96, -32));
		
		interactableObjects.add(new InteractableObject(80, 32, new String[]{"It's a TV."}));
		interactableObjects.add(new InteractableObject(96, 32, new String[]{"A whole collection", "of POKeMon picture", "books!"}));
	}
}
