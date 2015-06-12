package taxproblem;

public enum Goods {

	BOOK("book"), CD("music cd"), CHOCOLATE("chocolate bar");

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
			return true;
		default:
			return false;
		}

	}

	public boolean isImported() {
		switch (this) {
		default:
			return false;
		}
	}

}
