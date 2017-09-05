package roadrationing.awslamda;

import java.time.LocalDateTime;
import java.util.Set;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import roadrationing.functions.FunctionFactory;

public class CheckByTimeHanlder implements RequestHandler<String, Set<String>> {

	@Override
	public Set<String> handleRequest(String dateTimeString, Context context) {

		return FunctionFactory.getNumbersAtTimeFunction().apply(LocalDateTime.parse(dateTimeString));

	}

}
