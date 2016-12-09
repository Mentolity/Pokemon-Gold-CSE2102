package maps;

import gfx.Map;

public class CherryGroveCityMap5 extends Map{
	public CherryGroveCityMap5(Map parent) {
		super("/House1.png", "/House1PointMap.png");
		doors.add(new Door(48, 144, parent, 4336, 3552));
		doors.add(new Door(64, 144, parent, 4336, 3552));
		
		interactableObjects.add(new InteractableObject(16, 32, new String[]{"POKeMON magazines.", "POKeMON  PAL,", "POKeMON HANDBOOK,", "POKeMON GRAPH"}));
		interactableObjects.add(new InteractableObject(32, 32, new String[]{"POKeMON magazines.", "POKeMON  PAL,", "POKeMON HANDBOOK,", "POKeMON GRAPH"}));
		interactableObjects.add(new InteractableObject(48, 32, new String[]{"It's a TV."}));
		interactableObjects.add(new InteractableObject(64, 16, new String[]{"It's the TOWN MAP."}));
		interactableObjects.add(new InteractableObject(96, 16, new String[]{"My reflection!", "Lookin' good!"}));
	}
}
