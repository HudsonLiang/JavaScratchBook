package roadrotation;

public enum NumberCombination {

	ONE_SIX {
		@Override
		public String[] getNumbers() {
			return new String[] { "1", "6" };
		}
	},
	TWO_SEVEN {
		@Override
		public String[] getNumbers() {
			return new String[] { "2", "7" };
		}
	},
	ALL {

		@Override
		public String[] getNumbers() {
			return new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8",
					"9" };
		}

	},
	ODD {

		@Override
		public String[] getNumbers() {
			return new String[] { "1", "3", "5", "7", "9" };
		}
	},
	EVEN {

		@Override
		public String[] getNumbers() {
			return new String[] { "0", "2", "4", "6", "8" };
		}
	};

	public abstract String[] getNumbers();
}
