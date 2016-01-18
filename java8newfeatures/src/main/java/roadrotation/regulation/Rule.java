package roadrotation.regulation;

import java.time.LocalDateTime;
import java.util.SortedMap;

import roadrotation.NumberCombination;

public interface Rule {

	SortedMap<LocalDateTime, NumberCombination> apply(LocalDateTime instant);

}
