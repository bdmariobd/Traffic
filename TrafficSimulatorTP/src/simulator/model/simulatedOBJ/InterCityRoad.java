package simulator.model.simulatedOBJ;

import simulator.exceptions.IncorrectValues;
import simulator.model.Weather;

public class InterCityRoad extends Road {

	InterCityRoad(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length,
			Weather weather) throws IncorrectValues {
		super(id, srcJunc, destJunc, maxSpeed, contLimit, length, weather);
		// TODO Auto-generated constructor stub
	}
	void reduceTotalContamination() { //que aberracion , se pueden cambiar a protected
		setTotalCont((int)((100.0-getWeather().getContInterCity())/100.0)*getTotalCont());
	}

}
