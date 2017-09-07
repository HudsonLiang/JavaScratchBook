package roadrationing.app;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import roadrationing.functions.FunctionFactory;

public class LocalRunner {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Set<String> numbers = FunctionFactory.getNumbersAtTimeFunction().apply(LocalDateTime.now());
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.writeValue(new OutputStreamWriter(System.out), numbers);

	}

}
