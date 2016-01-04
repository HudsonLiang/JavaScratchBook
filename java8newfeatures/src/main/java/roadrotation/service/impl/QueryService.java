package roadrotation.service.impl;

import roadrotation.Rotater;
import roadrotation.service.Query;

public class QueryService implements Query {

	private Rotater manager;

	@Override
	public String[] whatNow() {

		return manager.getOffRoadNumbers();
	}

}
