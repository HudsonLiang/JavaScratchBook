package roadrationing.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class AopModule extends AbstractModule {

	@Override
	protected void configure() {
		
		FunctionLoggerInterceptor loggerInterceptor = new FunctionLoggerInterceptor();
		requestInjection(loggerInterceptor);
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(EntryExitLog.class), loggerInterceptor);

	}

}
