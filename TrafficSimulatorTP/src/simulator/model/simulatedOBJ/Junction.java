package simulator.model.simulatedOBJ;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import simulator.model.DequeuingStrategy;
import simulator.model.LightSwitchingStrategy;

public class Junction extends SimulatedObject {

	private List<Road> entryRoads;
	private Map<Junction,Road> exitRoads;
	private List<List<Vehicle>> qRoadList;
	private int gLight, gSwitchLight;
	private LightSwitchingStrategy lStrategy;
	private DequeuingStrategy dqStrategy;
	//int x,y; // coords para dibujar en la próxima práctica. UNUSED;
	Junction(String id, LightSwitchingStrategy lsStrategy, DequeuingStrategy dqeStrategy, int xCoor, int yCoor){ {
		if(lsStrategy==null) {throw IncorrectValues("La estrategia es null");}
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
