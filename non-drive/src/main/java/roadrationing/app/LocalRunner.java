package roadrationing.app;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Key;

import roadrationing.init.ProcessorModule;
import roadrationing.init.FunctionsModule;
import roadrationing.init.NumberAtTimeFunctionProvider.NumberAtTime;

public class LocalRunner {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		@SuppressWarnings("unchecked")
		Function<LocalDateTime, Set<String>> function = Guice.createInjector(new ProcessorModule(), new FunctionsModule())
				.getInstance(Key.get(Function.class, NumberAtTime.class));

		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.writeValue(new OutputStreamWriter(System.out), function.apply(LocalDateTime.now()));

	}

}
