package simulator.factories;

import org.json.JSONObject;

import simulator.model.Event;
import simulator.model.NewRoadEvent;
import simulator.model.Weather;

public abstract class NewRoadEventBuilder extends Builder<Event> {

	NewRoadEventBuilder(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	protected Event createTheInstance(JSONObject data) {
		return createTheRoad(data.getInt("time"),data.getString("id"),data.getString("src"),data.getString("dest")
				,data.getInt("length"),data.getInt("co2limit"),data.getInt("maxspeed"),
				Weather.getWeatherByString(data.getString("weather")));
	}

	/*
	 * "time" : 1, "id" : "r3", "src" : "j3", "dest" : "j4", "length" : 10000,
	 * "co2limit" : 500, "maxspeed" : 120, "weather" : "SUNNY"
	 */
	protected abstract Event createTheRoad(int time, String id, String src, String dest, int length, 
			int co2Limit, int maxspeed, Weather weather);
	
}
