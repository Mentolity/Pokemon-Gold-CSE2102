package maps;

import gfx.Map;

public class MainMap extends Map{
	public MainMap() {
		super("/worldMap.png", "/worldPointMap.png");
		//New Bark Town
		doors.add(new Doors(5696, 3504, new ElmsLab(this), 16, 128));
		doors.add(new Doors(5808, 3536, new HiroHouseLowerLevel(this), 48, 64));
		doors.add(new Doors(5648, 3632, new NewBarkTownMap5(this), -16, 64));
		doors.add(new Doors(5776, 3664, new NewBarkTownMap6(this), -16, 64));
		
		//CherryGrove City
		doors.add(new Doors(4272, 3568, new CherryGroveCityMap4(this), -16, 64));
		doors.add(new Doors(4400, 3600, new CherryGroveCityMap5(this), -16, 64));
		doors.add(new Doors(4496, 3632, new CherryGroveCityMap6(this), -16, 64));
		doors.add(new Doors(4368, 3504, new CherryGroveCityPokeMartMap(this), -16, 64));
		doors.add(new Doors(4464, 3504, new CherryGroveCityPokeCenterMap(this), 0, 64));
	}
}
