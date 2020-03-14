
package simulator.model.simulatedOBJ;

import simulator.exceptions.IncorrectValues;
import simulator.model.Weather;

public class InterCityRoad extends Road {

	public InterCityRoad(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length,
			Weather weather) throws IncorrectValues {
		super(id, srcJunc, destJunc, maxSpeed, contLimit, length, weather);
		// TODO Auto-generated constructor stub
	}
	void reduceTotalContamination() { //que aberracion , se pueden cambiar a protected
		setTotalCont((int)Math.ceil((100.0-getWeather().getContInterCity())/100.0)*getTotalCont());
	}
	@Override
	void updateSpeedLimit() {
		// TODO Auto-generated method stub
		if(getTotalCont()>getContLimit()) setActualMaxSpeed((int)(getMaxSpeed()*0.5));
		else setActualMaxSpeed((getMaxSpeed()));
		
	}
	@Override
	int calculateVehicleSpeed(Vehicle v) {
		// TODO Auto-generated method stub
		double speed;
		if(getWeather()==Weather.STORM) speed = (this.getActualMaxSpeed()*0.8);
		else speed= getActualMaxSpeed();
		if(speed>v.getMaxSpeed()) return v.getMaxSpeed();
		return (int)speed;
	}

}
