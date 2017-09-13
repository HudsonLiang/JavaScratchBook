package roadrationing.init;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Provider;

import roadrationing.functions.NumberAtTimeFunction;
import roadrationing.regulation.RulesProcessor;

public class NumberAtTimeFunctionProvider implements Provider<Function<LocalDateTime, Set<String>>> {

	private final RulesProcessor xmlRulesProcessor;

	@Inject
	public NumberAtTimeFunctionProvider(RulesProcessor xmlRulesProcessor) {

		this.xmlRulesProcessor = xmlRulesProcessor;

	}

	@Override
	public Function<LocalDateTime, Set<String>> get() {

		NumberAtTimeFunction functionReturned = new NumberAtTimeFunction();

		functionReturned.setRulesProcessor(xmlRulesProcessor);

		return functionReturned;
	}

	@BindingAnnotation
	@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface NumberAtTime {
	}

}