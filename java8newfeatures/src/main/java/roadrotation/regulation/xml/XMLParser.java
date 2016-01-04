package roadrotation.regulation.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import roadrotation.regulation.Parser;
import roadrotation.regulation.Rule;

public class XMLParser implements Parser {

	private File ruleFile;
	
	public Rule[] parse() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		Document doc = builder.parse(ruleFile);
		doc.getChildNodes();
		return null;
	}

}
