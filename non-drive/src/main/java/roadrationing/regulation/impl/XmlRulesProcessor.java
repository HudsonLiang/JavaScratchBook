package roadrationing.regulation.impl;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;

import roadrationing.regulation.ApplicableRule;
import roadrationing.regulation.RulesProcessor;
import roadrationing.regulation.WeekDayRuleTypeProcessor;
import roadrationing.regulation.XMLParser;
import roadrationing.regulation.xml.Rules;

public class XmlRulesProcessor implements RulesProcessor {
	
	public static final String XML_RULE_FILE="/rules.xml";

	private File xmlRulesFile;

	private WeekDayRuleTypeProcessor weekDayRuleTypeProcessor;

	@Override
	public Optional<ApplicableRule> findEffectiveRules(LocalDateTime when) {
		
		if(xmlRulesFile == null) {
			try {
				xmlRulesFile = new File(this.getClass().getResource(XML_RULE_FILE).toURI());
			} catch (URISyntaxException e) {
				
				
			}

		}
		

		Rules rules = xmlRulesFile != null ? XMLParser.parse(xmlRulesFile) : new Rules();
		

		Optional<ApplicableRule> appicalbeWeekDayRule = weekDayRuleTypeProcessor.findEffective(rules.getWeekDayRules(),
				when.toLocalDate());

		return appicalbeWeekDayRule.filter(ruleValue -> {
			return when.isAfter(ruleValue.getStart()) && when.isBefore(ruleValue.getEnd());

		});

	}

	public WeekDayRuleTypeProcessor getWeekDayRuleTypeProcessor() {
		return weekDayRuleTypeProcessor;
	}

	public void setWeekDayRuleTypeProcessor(WeekDayRuleTypeProcessor weekDayRuleTypeProcessor) {
		this.weekDayRuleTypeProcessor = weekDayRuleTypeProcessor;
	}

	
}
