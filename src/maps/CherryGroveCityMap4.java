package maps;

import gfx.Map;

public class CherryGroveCityMap4 extends Map{
	public CherryGroveCityMap4(Map parent) {
		super("/House1.png", "/House1PointMap.png");
		doors.add(new Door(48, 144, parent, 4208, 3520));
		doors.add(new Door(64, 144, parent, 4208, 3520));
	}
}
