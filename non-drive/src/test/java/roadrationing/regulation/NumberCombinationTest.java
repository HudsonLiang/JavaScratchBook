package roadrationing.regulation;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import roadrationing.regulation.NumberCombination;

public class NumberCombinationTest {

	@Test
	public void testGetNumbers() {
		// just test if order of number are in place

		String[] _3_8 = { "8", "3" };

		assertEquals(NumberCombination.getInstance(_3_8), NumberCombination.THREE_EIGH);
		assertArrayEquals(new String[] { "3", "8" }, NumberCombination.THREE_EIGH.getNumbers().toArray());

		String[] _2_7 = { "2", "7" };
		assertEquals(NumberCombination.getInstance(_2_7), NumberCombination.TWO_SEVEN);
		assertArrayEquals(_2_7, NumberCombination.TWO_SEVEN.getNumbers().toArray());
		String[] _1_6 = { "6", "1" };
		assertEquals(NumberCombination.getInstance(_1_6), NumberCombination.ONE_SIX);

		assertArrayEquals(new String[] { "1", "6" }, NumberCombination.ONE_SIX.getNumbers().toArray());
		
		String[] _4_9 = { "9", "4" };
		assertEquals(NumberCombination.getInstance(_4_9), NumberCombination.FOUR_NINE);
		assertArrayEquals(new String[] { "4", "9" }, NumberCombination.FOUR_NINE.getNumbers().toArray());
		
		String[] _5_0 = { "5", "0" };
		assertEquals(NumberCombination.getInstance(_5_0), NumberCombination.ZERO_FIVE);
		assertArrayEquals(new String[] { "0", "5" }, NumberCombination.ZERO_FIVE.getNumbers().toArray());
		
		String[] odd = { "1", "5", "3", "7", "9" };
		assertEquals(NumberCombination.getInstance(odd), NumberCombination.ODD);
		assertArrayEquals(new String[] { "1", "3", "5", "7", "9" }, NumberCombination.ODD.getNumbers().toArray());
		
		String[] even = { "2", "4", "6", "0", "8" };
		assertEquals(NumberCombination.getInstance(even), NumberCombination.EVEN);
		assertArrayEquals(new String[] { "0", "2", "4", "6", "8" }, NumberCombination.EVEN.getNumbers().toArray());

		String[] other = { "3", "8", "2" };
		assertEquals(NumberCombination.getInstance(other), NumberCombination.ALL);

	}

}
