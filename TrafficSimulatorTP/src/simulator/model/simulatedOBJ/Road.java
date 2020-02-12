package simulator.model.simulatedOBJ;

import java.util.List;

import org.json.JSONObject;

import simulator.exceptions.IncorrectValues;
import simulator.model.Weather;

public class Road extends SimulatedObject {
	private Junction srcJunc, destJunc;
	private int length,maxSpeed,actualMaxSpeed, contLimit;
	private Weather weather;
	private List<Vehicle> vehicleList;
	// comentario de prueba1
	// comentario de prueba2
	
	Road(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length, Weather weather) throws IncorrectValues {
		super(id);
		if(maxSpeed<0) throw new IncorrectValues("Negative Speed");
		if(length<0) throw new IncorrectValues("Negative length");
		if(contLimit<0) throw new IncorrectValues("Negative contLimit");
		if(srcJunc==null || destJunc==null) throw new IncorrectValues("Null junction");
		if(weather==null)throw new IncorrectValues("Null weather");
		this.srcJunc=srcJunc;
		this.destJunc=destJunc;
		this.maxSpeed=maxSpeed;
		this.contLimit=contLimit;
		this.length=length;
		this.weather=weather;
	}
	void enter(Vehicle v) throws IncorrectValues {
		if(!v.initial()) throw new IncorrectValues("Unable to join the road");
		vehicleList.add(v);
	}
	@Override
	void advance(int time) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}

}
