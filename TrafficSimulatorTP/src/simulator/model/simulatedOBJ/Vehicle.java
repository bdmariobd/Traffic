package simulator.model.simulatedOBJ;



import org.json.JSONObject;
import simulator.exceptions.IncorrectValues;
import simulator.model.VehicleStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vehicle extends SimulatedObject implements Comparable<Vehicle> { 
	private List<Junction> itinerary;
	private int maxSpeed,Speed, location,contClass,totalContClass,totalDistance;
	private VehicleStatus status;
	private Road road;
	
	
	Vehicle(String id, int maxSpeed, int contClass,	List<Junction> itinerary) throws IncorrectValues{
		super(id);
		// TODO complete
		correctValues(maxSpeed, contClass, itinerary);
		this.maxSpeed= maxSpeed;
		this.contClass=contClass;
		totalContClass=0;
		this.itinerary=Collections.unmodifiableList(new ArrayList<>(itinerary));
	}
	void correctValues(int maxSpeed, int contClass,	List<Junction> itinerary) throws IncorrectValues {
		if(maxSpeed<0) throw new IncorrectValues("Negative Speed");
		if(contClass>10 && contClass<0) throw new IncorrectValues("Incorrect contClass");
		if(itinerary.size()<2) throw new IncorrectValues("Not enought Junctions");
		
	}
	
	public Boolean initial() {
		return location==0 && Speed==0;
	}
	
	//public/protected??
	public void setSpeed(int speed) throws IncorrectValues {
		if(speed<0) throw new IncorrectValues("Negative Speed");
		Speed = speed;
	}
	public void setContClass(int contClass) throws IncorrectValues {
		if(contClass>10 && contClass<0) throw new IncorrectValues("Incorrect contClass");
		this.contClass = contClass;
	}
	@Override
	void advance(int time) {
		// TODO Auto-generated method stub
		if(status==VehicleStatus.TRAVELING) {
			int aux= location;
			location= Integer.min(location+Speed, 0); //distancia de road
			totalContClass+= contClass * (location-aux);
			//TODO road.addContamination();
			//TODO paso c
		}

	}
	void moveToNextRoad() {
		//TODO
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int compareTo(Vehicle v) {
		if(this.location==v.location) return 0;
		if(this.location<v.location) return -1;
		else return 1;
	}
	
}
