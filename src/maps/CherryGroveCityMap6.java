package maps;

import gfx.Map;

public class CherryGroveCityMap6 extends Map{
	public CherryGroveCityMap6(Map parent) {
		super("/House1.png", "/House1PointMap.png");
		doors.add(new Doors(48, 144, parent, 4432, 3584));
		doors.add(new Doors(64, 144, parent, 4432, 3584));
	}
}
