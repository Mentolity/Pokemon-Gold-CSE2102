package maps;

import gfx.Map;

public class HiroHouseUpperLevel extends Map{
	public HiroHouseUpperLevel(Map parent) {
		super("/HiroHouseUpperLevelMap.png", "/HiroHouseUpperLevelPointMap.png");
		doors.add(new Door(128, 16, parent, 96, -32));
	}
}
