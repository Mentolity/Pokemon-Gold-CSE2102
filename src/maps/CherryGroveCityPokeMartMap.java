package maps;

import gfx.Map;

public class CherryGroveCityPokeMartMap extends Map{
	public CherryGroveCityPokeMartMap(Map parent) {
		super("/PokeMartMap.png", "/PokeMartPointMap.png");
		doors.add(new Door(48, 144, parent, 4304, 3456));
		doors.add(new Door(64, 144, parent, 4304, 3456));
	}
}
