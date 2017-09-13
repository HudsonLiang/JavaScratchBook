package roadrationing.init;

import com.google.inject.AbstractModule;

import roadrationing.regulation.RulesProcessor;
import roadrationing.regulation.WeekDayRuleTypeProcessor;
import roadrationing.regulation.impl.DefaultWeekdayRuleTypeProcessor;
import roadrationing.regulation.impl.XmlRulesProcessor;

public class ProcessorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RulesProcessor.class).to(XmlRulesProcessor.class);
		bind(WeekDayRuleTypeProcessor.class).to(DefaultWeekdayRuleTypeProcessor.class);


	}

}
