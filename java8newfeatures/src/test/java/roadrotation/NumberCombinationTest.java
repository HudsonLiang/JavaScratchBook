package roadrotation;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NumberCombinationTest {

	@Test
	public void testGetNumbers() {
		// just test if order of number are in place

		String[] _3_8 = { "3", "8" };
		assertTrue(Arrays.equals(_3_8, NumberCombination.THREE_EIGH
				.getNumbers().toArray(new String[0])));
		assertEquals(NumberCombination.getInstance(_3_8),
				NumberCombination.THREE_EIGH);

		String[] _2_7 = { "2", "7" };
		assertEquals(NumberCombination.getInstance(_2_7),
				NumberCombination.TWO_SEVEN);
		String[] _1_6 = { "6", "1" };
		assertEquals(NumberCombination.getInstance(_1_6),
				NumberCombination.ONE_SIX);
		String[] _4_9 = { "9", "4" };
		assertEquals(NumberCombination.getInstance(_4_9),
				NumberCombination.FOUR_NINE);
		String[] _5_0 = { "5", "0" };
		assertEquals(NumberCombination.getInstance(_5_0),
				NumberCombination.ZERO_FIVE);
		String[] odd = { "1", "3", "5", "7", "9" };
		assertEquals(NumberCombination.getInstance(odd), NumberCombination.ODD);
		String[] even = { "2", "4", "6", "0", "8" };
		assertEquals(NumberCombination.getInstance(even),
				NumberCombination.EVEN);

		String[] other = { "3", "8", "2" };
		assertEquals(NumberCombination.getInstance(other),
				NumberCombination.ALL);

	}
}
