package simulator.factories;

import org.json.JSONObject;

import simulator.model.LightSwitchingStrategy;
import simulator.model.RoundRobinStrategy;

public class RoundRobinStrategyBuilder extends Builder<LightSwitchingStrategy> {

	RoundRobinStrategyBuilder() {
		super("round_robin_lss");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected RoundRobinStrategy createTheInstance(JSONObject data) {
		// TODO Auto-generated method stub
		return new RoundRobinStrategy(data.getInt("timeslot"));
	}

}
