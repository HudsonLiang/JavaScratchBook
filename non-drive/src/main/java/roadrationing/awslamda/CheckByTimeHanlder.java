package roadrationing.awslamda;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import roadrationing.functions.FunctionFactory;

public class CheckByTimeHanlder implements RequestHandler<String, Set<String>> {

	@Override
	public Set<String> handleRequest(String dateTimeString, Context context) {

		try {

			if (dateTimeString == null)
				throw new DateTimeException("Date time string is null");

			LocalDateTime dateTimeArg = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			return FunctionFactory.getNumbersAtTimeFunction().apply(dateTimeArg);

		} catch (DateTimeParseException e) {
			return FunctionFactory.getNumbersAtTimeFunction().apply(LocalDateTime.now());
		}
	}

}
