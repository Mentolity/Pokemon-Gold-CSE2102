package maps;

import gfx.Map;

public class CherryGroveCityPokeCenterMap extends Map{
	public CherryGroveCityPokeCenterMap(Map parent) {
		super("/PokeCenterMap.png", "/PokeCenterPointMap.png");
		doors.add(new Doors(64, 144, parent, 4400, 3456));
		doors.add(new Doors(80, 144, parent, 4400, 3456));
		doors.add(new Doors(16, 128, new CherryGroveCityPokeCenterUpperLevelMap(this), -32, 64));
	}
}
