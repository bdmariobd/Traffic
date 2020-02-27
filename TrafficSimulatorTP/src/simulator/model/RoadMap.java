package simulator.model;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import simulator.model.simulatedOBJ.*;

public class RoadMap {
	
	private List<Junction> lJunc;
	private List<Road> lRoad;
	private List<Vehicle> lVeh;
	private Map<String,Junction> juncMap;
	private Map<String,Road> roadMap;
	private Map<String,Vehicle> vehMap;
	
	
	//Recuerda tener actualizadas las listas y los mapas para usar los mapas en 
	//pro de la eficiencia de la búsqueda de un objeto;
	//y usar las listas para recorrer los objetos en 
	// mismo orden en el cual han sido añadidos
	
	RoadMap(List<Junction> lJunc,List<Road> lRoad,List<Vehicle> lVeh,Map<String,Junction> JuncMap,
			Map<String,Road> roadMap,Map<String,Vehicle> vehMap){
		this.lJunc=lJunc;
		this.lRoad=lRoad;
		this.lVeh=lVeh;
		this.juncMap=juncMap;
		this.roadMap=roadMap;
		this.vehMap=vehMap;
	}	
	void addJunction(Junction j) {
		lJunc.add(j);
		if(getJunction(j.getId()) == null) {
			juncMap.put(j.getId(), j);
		}
	}
	void addRoad(Road r) { // falta que tire excep
		lRoad.add(r);
		if(getRoad(r.getId())==null && juncMap.containsValue(r.getSrcJunc()) && 
				juncMap.containsValue(r.getDestJunc())) {
			roadMap.put(r.getId(),r);
		}
	}
	void addVehicle(Vehicle v) { // falta q tire except
		lVeh.add(v);
		if(getVehicle(v.getId())==null) {// falta comprobar la movida esa {
			 
			
			
			vehMap.put(v.getId(),v);
		}
	}
	public Junction getJunction(String id) {
		return juncMap.get(id);
	};
	public Road getRoad(String id) {
		return roadMap.get(id);
	};
	public Vehicle getVehicle(String id) {
		return vehMap.get(id);
	};
	//TODO public List<Junction>getJunctions(){};
	//TODO public List<Roads>getRoads(){};
	//TODO public List<Vehicle>getVehicles(){};
	void reset() {
		lJunc.clear();
		lRoad.clear();
		lVeh.clear();
		juncMap.clear();
		roadMap.clear();
		vehMap.clear();
	};
	//public JSONObject report() {};
	
	
}

