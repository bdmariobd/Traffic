package simulator.factories;

import org.json.JSONObject;

import simulator.model.LightSwitchingStrategy;
import simulator.model.MostCrowdedStrategy;
import simulator.model.RoundRobinStrategy;

public class MostCrowdedStrategyBuilder extends Builder<LightSwitchingStrategy> {

	MostCrowdedStrategyBuilder() {
		super("most_crowded_lss");
		 
	}

	@Override
	protected MostCrowdedStrategy createTheInstance(JSONObject data) {
		
		return new MostCrowdedStrategy(data.has("timeslot") ? data.getInt("timeslot"): 1);
	}

}