package roadrotation.regulation.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import roadrotation.regulation.Parser;
import roadrotation.regulation.Rule;

public class XMLParser implements Parser {

	private File ruleFile;

	private RuleBuilder ruleBuilder = new RuleBuilder();

	@Override
	public Stream<? extends Rule> parse() {

		try {
			JAXBContext jbc = JAXBContext.newInstance(Rules.class);

			Unmarshaller um = jbc.createUnmarshaller();

			Rules rules = (Rules) um.unmarshal(new FileInputStream(ruleFile));

			return ruleBuilder.buildRules(rules);
		} catch (FileNotFoundException | JAXBException e) {
			throw new RuntimeException(e);
		}
	}

}
