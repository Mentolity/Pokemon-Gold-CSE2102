package maps;

import gfx.Map;

public class CherryGroveCityPokeCenterUpperLevelMap extends Map{
	public CherryGroveCityPokeCenterUpperLevelMap(Map parent) {
		super("/PokeCenterUpperLevelMap.png", "/PokeCenterUpperLevelPointMap.png");
		doors.add(new Doors(16, 128, parent, -32, 64));
	}
}
