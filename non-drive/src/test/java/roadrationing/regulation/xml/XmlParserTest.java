package roadrationing.regulation.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import roadrationing.regulation.XMLParser;

public class XmlParserTest {

	@Test
	public void testParse() {
		File testXML = new File("src/test/resources/rules.xml");
		assertTrue(testXML.exists());

		Rules rules = XMLParser.parse(testXML);

		assertEquals(4, rules.getWeekDayRules().size());
		assertEquals(5, rules.getWeekDayRules().get(0).getWeekDaySequence().size());
		
		//need to test if rules returned from parser is in order

		assertEquals("1,6", rules.getWeekDayRules().get(0).getWeekDaySequence().get(0));
		assertEquals("4,9", rules.getWeekDayRules().get(0).getWeekDaySequence().get(3));
	}

}
