package roadrationing.awslamda;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;
import java.util.function.Function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import roadrationing.Initializer;
import roadrationing.functions.NumberAtTime;

public class CheckByTimeHanlder implements RequestHandler<String, Set<String>> {


	@Override
	public Set<String> handleRequest(String dateTimeString, Context context) {

		Function<LocalDateTime, Set<String>> function = Initializer.getFunction(NumberAtTime.class);

		try {

			if (dateTimeString == null)
				throw new DateTimeException("Date time string is null");

			LocalDateTime dateTimeArg = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

			return function.apply(dateTimeArg);

		} catch (DateTimeParseException e) {

			return function.apply(LocalDateTime.now(ZoneId.of("+8")));
		}
	}

}
