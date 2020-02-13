package simulator.model;

import java.util.Collections;
import java.util.List;

import simulator.model.simulatedOBJ.Vehicle;

public class MoveFirstStrategy implements DequeuingStrategy {

	public MoveFirstStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vehicle> dequeue(List<Vehicle> q) {
		
		List<Vehicle> v = Collections.emptyList();
		v.add(q.get(q.size()-1));
		return v;
	}

}
