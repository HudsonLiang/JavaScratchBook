package roadrotation.regulation;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.SortedMap;

import org.junit.Test;

import roadrotation.NumberCombination;

public class WeekDayRuleTest {

	@Test
	public void testApply() {

		LocalDateTime _2015_4_12 = LocalDateTime.of(2015, 4, 12, 14, 26, 30);

		LocalDateTime _2015_4_13 = LocalDateTime.of(2015, 4, 13, 14, 26, 30);

		LocalDateTime _2015_4_15 = LocalDateTime.of(2015, 4, 15, 14, 26, 30);

		WeekDayRule theRule = new WeekDayRule();
		theRule.setEffectiveDate(LocalDate.parse("2015-04-13"));
		String[] numbers = { "1", "6" };
		theRule.setOnRoadNumbers(numbers);

		// if the time is before the rule, expect 2 transitions
		SortedMap<LocalDateTime, NumberCombination> transitions = theRule
				.apply(_2015_4_12);

		assertEquals(NumberCombination.ONE_SIX,
				transitions.get(LocalDateTime.of(2015, 4, 13, 7, 0, 0)));
		assertEquals(NumberCombination.ALL,
				transitions.get(LocalDateTime.of(2015, 4, 13, 20, 0, 0)));

		assertEquals(2, transitions.size());

		// if the time is in the middle of the rule, expect 2 transitions
		transitions = theRule.apply(_2015_4_13);

		assertEquals(NumberCombination.ONE_SIX,
				transitions.get(LocalDateTime.of(2015, 4, 13, 7, 0, 0)));

		assertEquals(NumberCombination.ALL,
				transitions.get(LocalDateTime.of(2015, 4, 13, 20, 0, 0)));

		assertEquals(2, transitions.size());

		// if the time is behind rule, expect 0 transition
		transitions = theRule.apply(_2015_4_15);

		assertEquals(NumberCombination.ALL,
				transitions.get(LocalDateTime.of(2015, 4, 13, 20, 0, 0)));

		assertEquals(1, transitions.size());

	}
}
