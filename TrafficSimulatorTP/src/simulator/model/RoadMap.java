package simulator.model;

import java.util.ArrayList;
import java.util.Iterator;
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
	//TODO QUE CHINGO DE LISTA ES ESTO? LINKED, ARRAY??
	public List<Junction>getJunctions(){
		List<Junction> nList = new ArrayList<Junction>();
		Iterator <Junction> i = lJunc.iterator();
		while(i.hasNext()) {
			Junction aux= i.next();
			nList.add(aux);
		}
		return nList;
	
	}
	//TODO Revisar estas listas q hice copiar y pegar
	public List<Road>getRoads(){
	List<Road> nList = new ArrayList<Road>();
	Iterator <Road> i = lRoad.iterator();
		while(i.hasNext()) {
			Road aux= i.next();
			nList.add(aux);
		}
		return nList;
	};
	public List<Vehicle>getVehicles(){
	List<Vehicle> nList = new ArrayList<Vehicle>();
	Iterator <Vehicle> i = lVeh.iterator();
		while(i.hasNext()) {
			Vehicle aux= i.next();
			nList.add(aux);
		}
		return nList;
	};
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

