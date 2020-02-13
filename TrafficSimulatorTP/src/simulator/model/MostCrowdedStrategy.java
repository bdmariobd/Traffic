package simulator.model;

import java.util.Iterator;
import java.util.List;

import simulator.model.simulatedOBJ.Road;
import simulator.model.simulatedOBJ.Vehicle;

public class MostCrowdedStrategy implements LightSwitchingStrategy {
	private int timeSlot;
	public MostCrowdedStrategy(int timeSlot){
		this.timeSlot=timeSlot;
	};
	@Override
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, 
			int lastSwitchingTime,int currTime) {
		// TODO Auto-generated method stub
		
		if(roads.isEmpty()) return -1; //empty
		
		if(currGreen==-1) { //all red
			//funciona¿?
			Iterator<List<Vehicle>> it= qs.iterator();
			int max= it.next().size();
			while(it.hasNext()) {
				int aux= it.next().size();
				if(aux>max) max= aux;
			}
			return max;
		}
		if(currTime-lastSwitchingTime<timeSlot) return currGreen;
		//TODO paso 4
		return 0;
	}

}
