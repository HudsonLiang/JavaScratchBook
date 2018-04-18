package roadrationing.regulation.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import roadrationing.regulation.ApplicableRule;
import roadrationing.regulation.NumberCombination;
import roadrationing.regulation.WeekDayRuleTypeProcessor;
import roadrationing.regulation.XMLParser;
import roadrationing.regulation.impl.DefaultWeekdayRuleTypeProcessor;
import roadrationing.regulation.xml.Rules;
import roadrationing.regulation.xml.WeekDayRuleType;

public class DefaultWeekdayRuleTypeProcessorTest {

	private List<WeekDayRuleType> weekdayRuleTypeList;

	@Before
	public void setUp() throws Exception {

		File testXML = new File("src/test/resources/rules.xml");
		assertTrue(testXML.exists());

		Rules rules = XMLParser.parse(testXML);
		weekdayRuleTypeList = rules.getWeekDayRules();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWeekdayRuleDay() {

		WeekDayRuleTypeProcessor processorToTest = new DefaultWeekdayRuleTypeProcessor();
		Optional<ApplicableRule> applicableRule = processorToTest.findEffective(weekdayRuleTypeList,
				LocalDate.of(2018, 4, 18));
		assertTrue("No rule applicable found", applicableRule.isPresent());

		assertEquals(NumberCombination.ONE_SIX, applicableRule.get().getNumbersOffRoad());
	}

}
