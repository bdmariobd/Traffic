package simulator.model;

import java.util.List;

import simulator.exceptions.IncorrectValues;
import simulator.model.simulatedOBJ.Junction;
import simulator.model.simulatedOBJ.Road;
import simulator.model.simulatedOBJ.Vehicle;

public abstract class NewRoadEvent extends Event {
	protected Junction srcJunc, destJunc;
	protected int length,maxSpeed,actualMaxSpeed, co2Limit;
	protected Weather weather;
	protected String id;
	NewRoadEvent(int time, String id, Junction srcJun, Junction destJunc, int length, int co2Limit, int maxSpeed, Weather weather) {
		super(time);
		this.srcJunc=srcJunc;
		this.destJunc=destJunc;
		this.maxSpeed=maxSpeed;
		this.co2Limit=co2Limit;
		this.length=length;
		this.weather=weather;
		this.id=id;
	}

	@Override
	void execute(RoadMap map) throws IncorrectValues {
		// TODO Auto-generated method stub

	}
	abstract Road createRoadObject() throws IncorrectValues;
}
