package maps;

import gfx.Map;

public class MainMap extends Map{
	public MainMap() {
		super("/worldMap.png", "/worldPointMap.png");
		//New Bark Town
		doors.add(new Door(5696, 3504, new ElmsLab(this), 16, 128));
		doors.add(new Door(5808, 3536, new HiroHouseLowerLevel(this), 48, 64));
		doors.add(new Door(5648, 3632, new NewBarkTownMap5(this), -16, 64));
		doors.add(new Door(5776, 3664, new NewBarkTownMap6(this), -16, 64));
		
		//CherryGrove City
		doors.add(new Door(4272, 3568, new CherryGroveCityMap4(this), -16, 64));
		doors.add(new Door(4400, 3600, new CherryGroveCityMap5(this), -16, 64));
		doors.add(new Door(4496, 3632, new CherryGroveCityMap6(this), -16, 64));
		doors.add(new Door(4368, 3504, new CherryGroveCityPokeMartMap(this), -16, 64));
		doors.add(new Door(4464, 3504, new CherryGroveCityPokeCenterMap(this), 0, 64));
		
		
		//New Bark Town
		interactableObjects.add(new InteractableObject(5728, 3584, new String[]{"NEW BARK TOWN", "", "The Town Where the", "Winds of a New", "Beginning Blow"}));
		interactableObjects.add(new InteractableObject(5776, 3536, new String[]{"Hiro's" + " House"}));//Should pull actual player name
		interactableObjects.add(new InteractableObject(5648, 3504, new String[]{"ELM POKeMON LAB"}));
		interactableObjects.add(new InteractableObject(5744, 3664, new String[]{"ELM's HOUSE"}));
		
		//Route 29
		interactableObjects.add(new InteractableObject(5456, 3568, new String[]{"ROUTE 29", "", "CHERRYGROVE CITY -", "NEW BARK TOWN"}));
		interactableObjects.add(new InteractableObject(4688, 3536, new String[]{"ROUTE 29", "", "CHERRYGROVE CITY -", "NEW BARK TOWN"}));
		interactableObjects.add(new InteractableObject(5120, 3600, new String[]{"This tree can be", "CUT!"}));
		interactableObjects.add(new InteractableObject(4976, 3632, new String[]{"This tree can be", "CUT!"}));

		//Cherry Grove City
		interactableObjects.add(new InteractableObject(4480, 3584, new String[]{"CHERRYGROVE CITY", "", "The City of Cute,", "Fragrant Flowers"}));
		interactableObjects.add(new InteractableObject(4480, 3504, new String[]{"Heal Your POKeMON!", "POKeMON CENTER"}));
		interactableObjects.add(new InteractableObject(4384, 3504, new String[]{"For All Your", "POKeMON Needs", "*", "POKeMON MART", ""}));
		interactableObjects.add(new InteractableObject(4368, 3600, new String[]{"GUIDE GENT'S HOUSE"}));
		
	}
}
