package roadrationing.functions;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import com.google.inject.Provider;

public class TestNumberAtTimeFuntionProvider implements Provider<Function<LocalDateTime, Set<String>>> {

	@Override
	public Function<LocalDateTime, Set<String>> get() {

		return new TestFunction();
	}
	

}
