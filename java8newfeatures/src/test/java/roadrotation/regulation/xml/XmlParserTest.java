package roadrotation.regulation.xml;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.junit.Test;

import roadrotation.regulation.Rule;
import roadrotation.regulation.WeekDayRule;

public class XmlParserTest {

	String[] dates = { "2015-04-13", "2015-04-14", "2015-04-15", "2015-04-16",
			"2015-04-17", "2015-04-20" };
	String[][] numbers = { { "1", "6" }, { "2", "7" }, { "3", "8" },
			{ "4", "9" }, { "0", "5" }, { "1", "6" }, };

	@Test
	public void testParse() {
		File testXML = new File(
				"java8newfeatures/src/test/resources/roadrotation.xml");
		assertTrue(testXML.exists());

		XMLParser parser = new XMLParser();
		parser.setRuleFile(testXML);

		Stream<? extends Rule> ruleXMLParseResult = parser.parse();

		AtomicInteger i = new AtomicInteger(0);

		long ruleCount = ruleXMLParseResult.filter(therule -> {

			WeekDayRule expected = new WeekDayRule();
			expected.setEffectiveDate(LocalDate.parse(dates[i.get()]));
			expected.setOnRoadNumbers(numbers[i.get()]);

			i.getAndIncrement();
			return expected.equals(therule);

		}).count();

		assertEquals(6, ruleCount);
	}

}
