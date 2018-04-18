package roadrationing.functions;

import java.util.function.Function;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;


public class FunctionsModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(Function.class).annotatedWith(NumberAtTime.class).to(NumberAtTimeFunction.class).in(Scopes.SINGLETON);;

	}

}
