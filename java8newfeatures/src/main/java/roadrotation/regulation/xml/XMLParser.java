package roadrotation.regulation.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import roadrotation.regulation.Parser;
import roadrotation.regulation.Rule;

public class XMLParser implements Parser {

	private File ruleFile;

	public Rule[] parse() throws JAXBException, FileNotFoundException {

		JAXBContext jbc = JAXBContext.newInstance(Rules.class);
		
		Unmarshaller um = jbc.createUnmarshaller();
		
		Rules rules = (Rules) um.unmarshal(new FileInputStream(ruleFile));

		
		return null;
	}

}
