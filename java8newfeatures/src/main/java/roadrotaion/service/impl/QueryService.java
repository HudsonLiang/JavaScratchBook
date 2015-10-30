package roadrotaion.service.impl;

import roadrotaion.Manager;
import roadrotaion.service.Query;

public class QueryService implements Query {

	private Manager manager;

	@Override
	public String[] whatNow() {

		return manager.getOffRoadNumbers();
	}

}
