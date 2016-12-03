package maps;

import gfx.Map;

public class NewBarkTownMap6 extends Map{
	public NewBarkTownMap6(Map parent) {
		super("/NewBarkTownMap6.png", "/NewBarkTownMap6PointMap.png");
		doors.add(new Doors(48, 144, parent, 5712, 3616));
		doors.add(new Doors(64, 144, parent, 5712, 3616));
	}
}
