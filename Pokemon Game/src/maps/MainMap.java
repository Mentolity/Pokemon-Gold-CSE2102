package maps;

import gfx.Map;

public class MainMap extends Map{
	public MainMap() {
		super("/worldMap.png", "/worldPointMap.png");
		doors.add(new Doors(5696, 3504, new ElmsLab(this), 16, 128));
		doors.add(new Doors(5808, 3536, new HiroHouseLowerLevel(this), 48, 64));
	}
	
}
