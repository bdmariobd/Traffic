package simulator.model.simulatedOBJ;



import org.json.JSONObject;
import simulator.exceptions.IncorrectValues;
import simulator.model.VehicleStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

public class Vehicle extends SimulatedObject implements Comparable<Vehicle> { 
	private List<Junction> itinerary;
	private int maxSpeed,Speed, location,contClass,totalContClass,totalDistance;
	private VehicleStatus status;
	private Road road;
	
	
	public Vehicle(String id, int maxSpeed, int contClass,	List<Junction> itinerary) throws IncorrectValues{
		super(id);
		// TODO complete
		correctValues(maxSpeed, contClass, itinerary);
		this.maxSpeed= maxSpeed;
		this.contClass=contClass;
		totalContClass=0;
		this.itinerary=Collections.unmodifiableList(new ArrayList<>(itinerary));
		status= VehicleStatus.PENDING;
	}
	void correctValues(int maxSpeed, int contClass,	List<Junction> itinerary) throws IncorrectValues {
		if(maxSpeed<0) throw new IncorrectValues("Negative Speed");
		if(contClass>10 && contClass<0) throw new IncorrectValues("Incorrect contClass");
		if(itinerary.size()<2) throw new IncorrectValues("Not enought Junctions");
		
	}
	
	public Boolean initial() {
		return location==0 && Speed==0;
	}
	public void enterARoad() throws IncorrectValues {
		road.enter(this);
	}
	
	public Road getRoad() {
		return road;
	}
	public void setRoad(Road road) {
		this.road = road;
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
	void moveToNextRoad() throws IncorrectValues {
		//TODO
		if(status !=VehicleStatus.PENDING ||status !=VehicleStatus.WAITING) 
			throw new IncorrectValues("Vehicle cant move");
		if(status ==VehicleStatus.PENDING) {
			
		}
		else if(status ==VehicleStatus.WAITING) {
			Junction j = road.getDestJunc();
			
			j.roadTo(j);
		}
		//road.enter(this);
	}

	@Override
	public JSONObject report() {
		JSONObject jo= new JSONObject();
		jo.put("id", this._id);
		if(status!=VehicleStatus.TRAVELING && Speed!=0) jo.put("speed",0); 
		else jo.put("speed",this.Speed);
		jo.put("distance",this.totalDistance);
		jo.put("co2", this.totalContClass);
		jo.put("class", this.contClass);
		jo.put("status",this.status); //no sabemos si nos escribe el string o que
		jo.put("road", this.road.getId());
		jo.put("location", this.location);
		
		return jo;
	}
	
	@Override
	public int compareTo(Vehicle v) {
		if(this.location==v.location) return 0;
		if(this.location<v.location) return -1;
		else return 1;
	}
	public int getContClass() {
		return contClass;
	}
	public boolean validItinerary() {
		Iterator<Junction> i = itinerary.iterator();
		while(i.hasNext()) {
			//TODO comprobar ultima carretera itinerario
			Junction aux = i.next();
			if(aux.roadTo(i.next())==null) return false;
		}
		return true;
	}
}
