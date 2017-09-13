package roadrationing.init;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

public class Initializer {
	static Injector injector = Guice.createInjector(new FunctionsModule(), new ProcessorModule());
	
	@SuppressWarnings("unchecked")
	public static Function<LocalDateTime, Set<String>> getFunction(Class<? extends Annotation> annotationType) {
		return injector.getInstance(Key.get(Function.class, annotationType));
	}
}
