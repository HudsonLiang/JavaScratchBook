package roadrationing.init;

import java.util.function.Function;

import com.google.inject.AbstractModule;

import roadrationing.init.NumberAtTimeFunctionProvider.NumberAtTime;

public class FunctionsModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(Function.class).annotatedWith(NumberAtTime.class).toProvider(NumberAtTimeFunctionProvider.class);

	}


}
