package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simulator.exceptions.IncorrectValues;
import simulator.model.DequeuingStrategy;
import simulator.model.Event;
import simulator.model.LightSwitchingStrategy;
import simulator.model.NewJunctionEvent;

public class NewJunctionEventBuilder extends Builder<Event> {
	Factory<LightSwitchingStrategy>	lssFactory;
	Factory<DequeuingStrategy> dqsFactory;
	
	
	NewJunctionEventBuilder(Factory<LightSwitchingStrategy>	lssFactory, Factory<DequeuingStrategy> dqsFactory) {
		super("new_junction");
		this.lssFactory= lssFactory;
		this.dqsFactory=dqsFactory;
	}

	@Override
	protected Event createTheInstance(JSONObject data) throws JSONException, IncorrectValues {
		JSONArray coords = data.getJSONArray("coor"); // se podria usar una pareja perfectamente pero me da palo
		//TODO extraer las estrategias
		LightSwitchingStrategy ls= lssFactory.createInstance(data.getJSONObject("ls_strategy"));
		DequeuingStrategy ds = dqsFactory.createInstance(data.getJSONObject("dq_strategy"));
		return new NewJunctionEvent(data.getInt("time"), data.getString("id"), ls, ds ,coords.getInt(0), coords.getInt(1));
	}
}
