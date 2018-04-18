package roadrationing.regulation.impl;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import roadrationing.regulation.ApplicableRule;
import roadrationing.regulation.NumberCombination;
import roadrationing.regulation.impl.DefaultWeekdayRuleTypeProcessor;
import roadrationing.regulation.impl.XmlRulesProcessor;

public class XmlRulesProcessorTest {

	private Optional<ApplicableRule> applicableRule;
	private LocalDateTime DT_2018_8_30_7AM = LocalDateTime.of(2018, 8, 30, 7, 0);
	private LocalDateTime DT_2018_8_30_8PM = LocalDateTime.of(2018, 8, 30, 20, 0);

	@Before
	public void setUp() throws Exception {

		applicableRule = Optional.of(new ApplicableRule(NumberCombination.ALL, DT_2018_8_30_7AM, DT_2018_8_30_7AM));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFilterWeekdayRule() {

		XmlRulesProcessor xmlProcessor = new XmlRulesProcessor();

		xmlProcessor.setWeekDayRuleTypeProcessor(new DefaultWeekdayRuleTypeProcessor());
		Optional<ApplicableRule> ruleReturned = xmlProcessor.findEffectiveRules(LocalDateTime.of(2018, 8, 30, 14, 12));
		assertTrue(ruleReturned.isPresent());
		ruleReturned = xmlProcessor.findEffectiveRules(LocalDateTime.of(2018, 8, 30, 20, 12));
		assertTrue(!ruleReturned.isPresent());

	}

}
