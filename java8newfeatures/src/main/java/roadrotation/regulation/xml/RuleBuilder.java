package roadrotation.regulation.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import roadrotation.regulation.Rule;

public class RuleBuilder {

	private List<Function<Rules, Stream<? extends Rule>>> xmlProcessors = new ArrayList<Function<Rules, Stream<? extends Rule>>>(0);

	public RuleBuilder() {

		xmlProcessors.add(new WeekDayRuleProcessor());
	}

	public Stream<? extends Rule> buildRules(Rules xmlRules) {

		return xmlProcessors.stream().flatMap(
				processor -> processor.apply(xmlRules));

	}

}
