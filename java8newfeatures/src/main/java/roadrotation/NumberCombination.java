package roadrotation;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public enum NumberCombination {

	ONE_SIX {
		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("1", "6"));
		}
	},
	TWO_SEVEN {
		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("2", "7"));
		}
	},
	THREE_EIGH {
		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("8", "3"));
		}
	},
	FOUR_NINE {
		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("4", "9"));
		}
	},
	ZERO_FIVE {
		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("5", "0"));
		}
	},

	ALL {

		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("0", "1", "2", "3", "4",
					"5", "6", "7", "8", "9"));
		}

	},
	ODD {

		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("1", "3", "5", "7", "9"));
		}
	},
	EVEN {

		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("0", "2", "4", "6", "8"));
		}
	};

	public abstract SortedSet<String> getNumbers();

	public static NumberCombination getInstance(String[] numbers) {

		if (ONE_SIX.getNumbers().equals(
				new TreeSet<String>(Arrays.asList(numbers))))
			return ONE_SIX;

		if (TWO_SEVEN.getNumbers().equals(
				new TreeSet<String>(Arrays.asList(numbers))))
			return TWO_SEVEN;
		if (THREE_EIGH.getNumbers().equals(
				new TreeSet<String>(Arrays.asList(numbers))))
			return THREE_EIGH;
		if (FOUR_NINE.getNumbers().equals(
				new TreeSet<String>(Arrays.asList(numbers))))
			return FOUR_NINE;
		if (ZERO_FIVE.getNumbers().equals(
				new TreeSet<String>(Arrays.asList(numbers))))
			return ZERO_FIVE;

		if (ODD.getNumbers()
				.equals(new TreeSet<String>(Arrays.asList(numbers))))
			return ODD;

		if (EVEN.getNumbers().equals(
				new TreeSet<String>(Arrays.asList(numbers))))
			return EVEN;

		return ALL;

	}
}
