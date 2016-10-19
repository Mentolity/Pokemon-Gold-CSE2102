package maps;

import gfx.Map;

public class HiroHouseUpperLevel extends Map{
	public HiroHouseUpperLevel(Map parent) {
		super("/HiroHouseUpperLevelMap.png", "/HiroHouseUpperLevelPointMap.png");
		doors.add(new Doors(112, 0, parent, 96, -32));
	}
}
