package roadrationing.app;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import roadrationing.Initializer;
import roadrationing.functions.NumberAtTime;

public class LocalRunner {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Function<LocalDateTime, Set<String>> function = Initializer.getFunction(NumberAtTime.class);

		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.writeValue(new OutputStreamWriter(System.out), function.apply(LocalDateTime.now()));

	}

}
