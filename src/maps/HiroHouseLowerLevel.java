package maps;

import gfx.Map;

public class HiroHouseLowerLevel extends Map{

	public HiroHouseLowerLevel(Map parent) {
		super("/HiroHouseLowerLevelMap.png", "/HiroHouseLowerLevelPointMap.png");
		doors.add(new Door(112, 144, parent, 5744, 3488));
		doors.add(new Door(128, 144, parent, 5744, 3488));
		doors.add(new Door(160, 16, new HiroHouseUpperLevel(this), 64, -32));
	}

}
