package simulator.model.simulatedOBJ;

import java.util.Iterator;
import java.util.List;

import simulator.model.LightSwitchingStrategy;

public class MostCrowdedStrategy implements LightSwitchingStrategy {

	@Override
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, int lastSwitchingTime,
			int currTime) {
		// TODO Auto-generated method stub
		if(roads.isEmpty()) return -1;
		if(currGreen==-1) {
			Iterator<List<Vehicle>> it= qs.iterator();
			int max= it.next().size();
			while(it.hasNext()) {
				int aux= it.next().size();
				if(aux>max) max= aux;
			}
			return max;
		}
		
		return 0;
	}

}
