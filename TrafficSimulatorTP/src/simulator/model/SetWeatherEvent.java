package simulator.model;

import java.util.Iterator;
import java.util.List;

import simulator.exceptions.IncorrectValues;
import simulator.misc.Pair;
import simulator.model.simulatedOBJ.Road;

public class SetWeatherEvent extends Event {
	List<Pair<String,Weather>> ws;
	public SetWeatherEvent(int time,List<Pair<String,Weather>> ws) throws IncorrectValues {
		super(time);
		// TODO Auto-generated constructor stub
		if(ws==null) throw new IncorrectValues("Null list");
		this.ws=ws;
	}

	@Override
	void execute(RoadMap map) throws IncorrectValues {
		// TODO Auto-generated method stub
		Iterator <Pair<String,Weather>> i= ws.iterator();
		while(i.hasNext()) {
			Pair<String,Weather> aux= i.next();
			Road r = map.getRoad(aux.getFirst());
			if(r==null) throw new IncorrectValues("No existe una carretera con id " + aux.getFirst());
			r.setWeather(aux.getSecond());
		}
	}

}
