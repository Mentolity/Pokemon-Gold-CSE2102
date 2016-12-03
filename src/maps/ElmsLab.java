package maps;

import gfx.Map;

public class ElmsLab extends Map{
	public ElmsLab(Map parent) {
		super("/ElmsLabMap.png", "/ElmsLabPointMap.png");
		doors.add(new Door(80, 208, parent, 5632, 3456));
		doors.add(new Door(96, 208, parent, 5632, 3456));
	}
}
