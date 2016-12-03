package maps;

import gfx.Map;

public class NewBarkTownMap5 extends Map{
	public NewBarkTownMap5(Map parent) {
		super("/House1.png", "/House1PointMap.png");
		doors.add(new Door(48, 144, parent, 5584, 3584));
		doors.add(new Door(64, 144, parent, 5584, 3584));
	}
}
