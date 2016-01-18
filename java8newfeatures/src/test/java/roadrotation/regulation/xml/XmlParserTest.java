package roadrotation.regulation.xml;

import static org.junit.Assert.*;

import java.io.File;
import java.util.stream.Stream;

import org.junit.Test;

import roadrotation.regulation.Rule;

public class XmlParserTest {

	@Test
	public void testParse() {
		File testXML = new File("src/test/resources/roadrotation.xml");
		assertTrue(testXML.exists());

		XMLParser parser = new XMLParser();
		parser.setRuleFile(testXML);

		Stream<? extends Rule> ruleXMLParseResult = parser.parse();

		assertEquals(15, ruleXMLParseResult.count());
	}

}
