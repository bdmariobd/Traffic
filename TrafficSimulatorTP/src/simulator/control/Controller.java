package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.exceptions.IncorrectValues;
import simulator.factories.Factory;
import simulator.model.Event;
import simulator.model.TrafficSimulator;

public class Controller {
	
	private TrafficSimulator sim;
	private Factory<Event> eventsFactory;
	
	public Controller(TrafficSimulator sim, Factory<Event> eventsFactory) throws IncorrectValues{
		if(sim==null) throw new IncorrectValues("Null simulator");
		if(eventsFactory==null) throw new IncorrectValues("Null events Factory");
		this.sim=sim;
		this.eventsFactory= eventsFactory;
	}
	
	public void loadEvents(InputStream in) throws IncorrectValues {
		JSONObject jo = new JSONObject(new JSONTokener(in));
		if(!jo.has("events")) throw new IncorrectValues("Incorrect Json bruh");
		JSONArray ja = jo.getJSONArray("events"); 
		for(int i=0;i<ja.length();++i) {
			Event e = eventsFactory.createInstance(ja.getJSONObject(i));
			if(e==null) throw new IncorrectValues("Incorrect event");
			sim.addEvent(e);	
		}
	}
	public void run(int n, OutputStream out) throws IncorrectValues {
		
		JSONObject jo = new JSONObject();
		for(int i=0;i<n;++i) {
			sim.advance();
			
		}
	}
	public void reset() {
		sim.reset();
	}
	
	
}
