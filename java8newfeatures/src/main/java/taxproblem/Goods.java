package taxproblem;

public enum Goods {

	BOOK("book"), CD("music cd"), CHOCOLATE("chocolate bar"), PILL(
			"headache pill"), IMPORTED_CHOCOLATE("imported box of chocolate"), IMPORTED_PERFUME(
			"imported bottle of perfume"), PERFUME("bottle of perfume");

	private String name;

	private Goods(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isFood() {

		switch (this) {
		case CHOCOLATE:
		case IMPORTED_CHOCOLATE:
			return true;
		default:
			return false;
		}

	}

	public boolean isImported() {
		switch (this) {
		case IMPORTED_CHOCOLATE:
		case IMPORTED_PERFUME:
			return true;
		default:
			return false;
		}
	}

	public boolean isBook() {
		switch (this) {
		case BOOK:
			return true;

		default:
			return false;
		}
	}

	public boolean isMedical() {
		switch (this) {
		case PILL:
			return true;
		default:
			return false;
		}
	}

	public String toString() {
		return name;
	}

}
