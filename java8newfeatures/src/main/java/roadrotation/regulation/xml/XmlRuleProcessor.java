package roadrotation.regulation.xml;

import java.util.function.Function;
import java.util.stream.Stream;

import roadrotation.regulation.Rule;

public interface XmlRuleProcessor extends Function<Rules, Stream<? extends Rule>> {

}
