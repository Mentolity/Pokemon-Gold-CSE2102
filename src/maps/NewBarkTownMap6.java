package maps;

import gfx.Map;

public class NewBarkTownMap6 extends Map{
	public NewBarkTownMap6(Map parent) {
		super("/NewBarkTownMap6.png", "/NewBarkTownMap6PointMap.png");
		doors.add(new Door(48, 144, parent, 5712, 3616));
		doors.add(new Door(64, 144, parent, 5712, 3616));

		interactableObjects.add(new InteractableObject(16, 32, new String[]{"POKeMON. Where do", "they come from?", "*", "Where are they", "going?", "*",
																			"Why has no one", "ever witnessed a", "POKeMON's birth?", "*", "I want to know! I",
																			"will dedicate my", "*", "life to the study", "of POKeMON!", "*", "", "", "It's a part of", "PROF.ELM's re-", "search papers."}));
		interactableObjects.add(new InteractableObject(80, 32, new String[]{"It's a TV."}));
		interactableObjects.add(new InteractableObject(112, 32, new String[]{"It's full of", "difficult books."}));

		interactableObjects.add(new InteractableObject(128, 32, new String[]{"It's full of", "difficult books."}));


	}
}
