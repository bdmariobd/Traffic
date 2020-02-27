package simulator.model;

import simulator.exceptions.IncorrectValues;
import simulator.model.simulatedOBJ.CityRoad;
import simulator.model.simulatedOBJ.InterCityRoad;
import simulator.model.simulatedOBJ.Junction;
import simulator.model.simulatedOBJ.Road;

public class NewInterCityRoad extends NewRoadEvent {
	
	
	public NewInterCityRoad(int time, String id, Junction srcJun, Junction destJunc, int length, int co2Limit, int maxSpeed, Weather weather) {
		super(time, id, srcJun, destJunc, length, co2Limit, maxSpeed, weather);
	}

	@Override
	Road createRoadObject() throws IncorrectValues {
		// TODO Auto-generated method stub
		return new InterCityRoad(id, srcJunc, destJunc, length, co2Limit, maxSpeed, weather);
	}
}
