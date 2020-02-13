package simulator.model;

import java.util.Iterator;
import java.util.List;

import simulator.model.simulatedOBJ.Road;
import simulator.model.simulatedOBJ.Vehicle;

public class RoundRobinStrategy implements LightSwitchingStrategy{
	private int timeSlot;
	public RoundRobinStrategy(int timeSlot) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, int lastSwitchingTime,
			int currTime) {

		if(roads.isEmpty()) return -1; //empty
		
		if(currGreen==-1) { //all red
			//funciona¿?
			return 0;
		}
		if(currTime-lastSwitchingTime<timeSlot) return currGreen;
		//TODO paso 4
		
		return (currGreen+1)%roads.size();
		
	}

}
