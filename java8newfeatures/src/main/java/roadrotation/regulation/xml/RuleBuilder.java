package roadrotation.regulation.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import roadrotation.regulation.Rule;
import roadrotation.regulation.WeekDayRule;

public class RuleBuilder {
	
	private List<Function<Rules, Stream<? extends Rule>>> xmlProcessors;

	public RuleBuilder() {

		xmlProcessors.add(new WeekDayRuleProcessor());
	}

	public Stream<? extends Rule> buildRules(Rules xmlRules){

		xmlProcessors.forEach();

	}

}
