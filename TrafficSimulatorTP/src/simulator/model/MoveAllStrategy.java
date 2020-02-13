package simulator.model;

import java.util.Collections;
import java.util.List;

import simulator.model.simulatedOBJ.Vehicle;

public class MoveAllStrategy implements DequeuingStrategy {
	@Override
	public List<Vehicle> dequeue(List<Vehicle> q) {
		
		List<Vehicle> v = Collections.emptyList();
		v.addAll(q);
		return v;
	}

}
