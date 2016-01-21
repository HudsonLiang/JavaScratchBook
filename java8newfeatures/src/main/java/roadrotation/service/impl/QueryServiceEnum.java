package roadrotation.service.impl;

import java.time.LocalDateTime;

import roadrotation.Rotater;
import roadrotation.service.Query;

public enum QueryServiceEnum implements Query {

	INSTANCE;

	private Rotater manager;

	private QueryServiceEnum() {
		manager = new Rotater();
		manager.init();
		manager.rotateAt(LocalDateTime.now());
	}

	@Override
	public String[] whatNow() {

		return manager.getInEffectNumbers().getNumbers().toArray(new String[0]);
	}

}
