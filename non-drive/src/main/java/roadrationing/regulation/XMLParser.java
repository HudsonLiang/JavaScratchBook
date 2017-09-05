package roadrationing.regulation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import roadrationing.regulation.xml.Rules;

public class XMLParser {

	public static Rules parse(File ruleFile) {

		try {
			JAXBContext jbc = JAXBContext.newInstance(Rules.class);

			Unmarshaller um = jbc.createUnmarshaller();

			return (Rules) um.unmarshal(new FileInputStream(ruleFile));

		} catch (FileNotFoundException | JAXBException e) {
			throw new RuntimeException(e);
		}
	}

}
