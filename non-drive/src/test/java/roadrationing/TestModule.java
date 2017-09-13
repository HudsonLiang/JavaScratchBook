package roadrationing;

import java.util.function.Function;

import com.google.inject.AbstractModule;

import roadrationing.functions.TestNumberAtTimeFuntionProvider;
import roadrationing.init.NumberAtTimeFunctionProvider.NumberAtTime;

public class TestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Function.class).annotatedWith(NumberAtTime.class).toProvider(TestNumberAtTimeFuntionProvider.class);


	}

}
