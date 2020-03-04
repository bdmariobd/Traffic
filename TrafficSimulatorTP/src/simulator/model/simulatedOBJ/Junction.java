package simulator.model.simulatedOBJ;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.model.DequeuingStrategy;
import simulator.model.LightSwitchingStrategy;
import simulator.exceptions.IncorrectValues;
public class Junction extends SimulatedObject {

	private List<Road> entryRoads;
	private Map<Junction,Road> exitRoads;
	private List<List<Vehicle>> qRoadList;
	private int gLight, gSwitchLight;
	private LightSwitchingStrategy lStrategy;
	private DequeuingStrategy dqStrategy;
	//int x,y; // coords para dibujar en la próxima práctica. UNUSED;
	public Junction(String id, LightSwitchingStrategy lsStrategy, DequeuingStrategy dqeStrategy, int xCoor, int yCoor) throws IncorrectValues{ 
		super(id);
		if(lsStrategy==null || dqeStrategy==null) throw new IncorrectValues("La estrategia es null");
		if(xCoor<0 || yCoor<0)throw new IncorrectValues("Coordenadas negativas");
		this.lStrategy=lsStrategy;
		this.dqStrategy=dqeStrategy;
	} 

	void addIncommingRoad(Road r) { // TODO Tratar los .add() ;
		if(r.checkEntryRoad(this)) { 
			if(entryRoads.add(r)) {
			List<Vehicle> l = new LinkedList<Vehicle>();
			qRoadList.add(l);
			}	
		}
	}
	boolean checkUnusedJunc(Junction j) {
		Iterator<Road> i=  entryRoads.iterator();
		while(i.hasNext()) {
			Road r=i.next();
			if(r.checkEntryRoad(j)) return false;
		}
		return true;
	}
	void addOutGoingRoad(Road r) {
		if(!r.checkEntryRoad(this) && checkUnusedJunc(r.getDestJunc())) {
			exitRoads.put(r.getDestJunc(), r);
		}
	}
	void enter(Vehicle V) throws IncorrectValues {
		V.enterARoad();
	}
	Road roadTo(Junction j) {
		return exitRoads.get(j);
	}
	@Override
	
	public void advance(int time) {
		//TODO extraccion cola
		int green = lStrategy.chooseNextGreen(entryRoads,qRoadList, gLight,gSwitchLight,time);
		if(green!=gLight) {
			gLight=green;
			gSwitchLight=time;
		}
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		JSONObject jo= new JSONObject();
		jo.put("id", this._id);
		if(gLight==-1) jo.put("green", "none");
		else jo.put("green", entryRoads.get(gLight).getId());
		JSONArray queues =new JSONArray();
		for(List<Vehicle> i : qRoadList ) {
			JSONObject queue= new JSONObject();
			JSONArray vehicles =new JSONArray();
			//TODO hay que escribir la carretera de la cola. Para esto, debemos implementar un Map<Road,List<Vehicles> para facilitar la busqueta
			queue.put("road", "rnull"); //TODO mal. Poner id carretera
			for(Vehicle j: i) vehicles.put(j.getId());
			queue.put("vehicles", vehicles);
			queues.put(queue);
		}
		jo.put("queues", queues);		
		return jo;
	}

}
