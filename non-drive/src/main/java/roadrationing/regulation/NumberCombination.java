package roadrationing.regulation;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonGetter;

@JsonFormat(shape = Shape.OBJECT)
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
			return new TreeSet<String>(Arrays.asList("0", "5"));
		}
	},

	ALL {

		@Override
		public SortedSet<String> getNumbers() {
			return new TreeSet<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
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

	@JsonGetter
	public abstract SortedSet<String> getNumbers();

	public static NumberCombination getInstance(String[] numbers) {

		Set<String> numberSet = Arrays.stream(numbers).distinct().collect(Collectors.toSet());

		if (ONE_SIX.getNumbers().equals(numberSet))
			return ONE_SIX;

		if (TWO_SEVEN.getNumbers().equals(numberSet))
			return TWO_SEVEN;
		if (THREE_EIGH.getNumbers().equals(numberSet))
			return THREE_EIGH;
		if (FOUR_NINE.getNumbers().equals(numberSet))
			return FOUR_NINE;
		if (ZERO_FIVE.getNumbers().equals(numberSet))
			return ZERO_FIVE;

		if (ODD.getNumbers().equals(numberSet))
			return ODD;

		if (EVEN.getNumbers().equals(numberSet))
			return EVEN;

		return ALL;

	}
}
