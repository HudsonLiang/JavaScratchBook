package roadrationing.functions;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import roadrationing.regulation.impl.DefaultWeekdayRuleTypeProcessor;
import roadrationing.regulation.impl.XmlRulesProcessor;

public class FunctionFactory {
	
	public static Function<LocalDateTime, Set<String>> getNumbersAtTimeFunction(){
		
		NumberAtTimeFunction functionReturned = new NumberAtTimeFunction();
		
		XmlRulesProcessor xmlProcessor = new XmlRulesProcessor();
		xmlProcessor.setWeekDayRuleTypeProcessor(new DefaultWeekdayRuleTypeProcessor());
		functionReturned.setRulesProcessor(xmlProcessor);
		
		return functionReturned;
	}

}
