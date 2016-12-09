package maps;

import gfx.Map;

public class CherryGroveCityPokeMartMap extends Map{
	public CherryGroveCityPokeMartMap(Map parent) {
		super("/PokeMartMap.png", "/PokeMartPointMap.png");
		doors.add(new Door(48, 144, parent, 4304, 3456));
		doors.add(new Door(64, 144, parent, 4304, 3456));

		interactableObjects.add(new InteractableObject(64, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(80, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(96, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(112, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(128, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(144, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(160, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(176, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(192, 32, new String[]{"Lots of POKeMON", "merchandise!"}));
		

		interactableObjects.add(new InteractableObject(16, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(32, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		
		
		interactableObjects.add(new InteractableObject(80, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(96, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(112, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(128, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(144, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		interactableObjects.add(new InteractableObject(160, 96, new String[]{"Lots of POKeMON", "merchandise!"}));
		
		
	}
}
