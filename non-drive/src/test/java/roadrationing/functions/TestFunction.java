package roadrationing.functions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestFunction implements Function<LocalDateTime, Set<String>> {
	
	public 	static	String[] numbers = {"3", "7","5"};

	@Override
	public Set<String> apply(LocalDateTime t) {
		

		Arrays.sort(numbers);
		
		Set<String> testResult = Arrays.stream(numbers).collect(Collectors.toSet());
		return testResult;
	}
	

}
