package simulator.model;

import simulator.exceptions.IncorrectValues;
import simulator.model.simulatedOBJ.CityRoad;
import simulator.model.simulatedOBJ.Junction;
import simulator.model.simulatedOBJ.Road;

public class NewCityRoad extends NewRoadEvent {

	public NewCityRoad(int time, String id, Junction srcJun, Junction destJunc, int length, int co2Limit, int maxSpeed, Weather weather) {
		super(time, id, srcJun, destJunc, length, co2Limit, maxSpeed, weather);
	}

	@Override
	Road createRoadObject() throws IncorrectValues {
		return new CityRoad(id, srcJunc, destJunc, length, co2Limit, maxSpeed, weather);
	}
	
}
