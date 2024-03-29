package simulator.model;

import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import simulator.exceptions.IncorrectValues;
import simulator.misc.SortedArrayList;
import simulator.model.simulatedOBJ.Junction;
import simulator.model.simulatedOBJ.Road;

public class TrafficSimulator {

	private RoadMap roadsMap;
	private List<Event> eventList;
	private int timeTick=0;
	
	public TrafficSimulator() {
		eventList = new SortedArrayList<Event>();
		roadsMap = new RoadMap();
	}
	
	public void addEvent(Event e) {
		eventList.add(e);
	}
	public void advance() throws IncorrectValues {
		++timeTick;
		for(Iterator<Event> i= eventList.iterator(); i.hasNext();  ) {
			Event e=i.next();
			if(e._time==timeTick) {
				i.remove();  // Borrar elementos de una lista es borrar el iterador.
				e.execute(roadsMap);
			}
		}
		List<Junction> juncs=roadsMap.getJunctions();
		Iterator<Junction> j= juncs.iterator();
		while(j.hasNext()) {
			Junction aux=j.next();
			aux.advance(timeTick);
		}
		List<Road> roads=roadsMap.getRoads();
		Iterator<Road> r= roads.iterator();
		while(r.hasNext()) {
			Road aux=r.next();
			aux.advance(timeTick);
		}	
	}
	public void reset() {
		roadsMap.reset();
		eventList.clear();
		timeTick=0;
	}
	
	public JSONObject report() {
		JSONObject jo= new JSONObject();
		jo.put("time", timeTick);
		jo.put("state", roadsMap.report());
		return jo;
	}
}
