package maps;

import gfx.Map;

public class HiroHouseLowerLevel extends Map{

	public HiroHouseLowerLevel(Map parent) {
		super("/HiroHouseLowerLevelMap.png", "/HiroHouseLowerLevelPointMap.png");
		doors.add(new Door(112, 144, parent, 5744, 3488));
		doors.add(new Door(128, 144, parent, 5744, 3488));
		doors.add(new Door(160, 16, new HiroHouseUpperLevel(this), 64, -32));
		
		interactableObjects.add(new InteractableObject(16, 32, new String[]{"Mom's specialty!", "", "*", "CINNABAR VOLCANO", "BURGER!"}));
		interactableObjects.add(new InteractableObject(32, 32, new String[]{"The sink is spot-", "less. Mom likes it", "clean."}));
		interactableObjects.add(new InteractableObject(48, 32, new String[]{"It's running.", "Better catch it."}));
		interactableObjects.add(new InteractableObject(80, 32, new String[]{"There's a movie on", "TV: Stars dot the", "*", "sky as two boys", "ride on a train.", "*", "I'd better get", "rolling too!"}));
		
	}

}
