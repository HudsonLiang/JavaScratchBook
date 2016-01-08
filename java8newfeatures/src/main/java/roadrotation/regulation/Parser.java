package roadrotation.regulation;

import java.util.stream.Stream;

public interface Parser {

	Stream<? extends Rule> parse();

}
