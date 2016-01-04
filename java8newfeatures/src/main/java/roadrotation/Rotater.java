package roadrotation;

public class Rotater {

	private String[][] rotationTable = { { "0", "5" }, { "1", "6" },
			{ "2", "7" }, { "3", "8" }, { "4", "9" }, { "-", "-" } };
	public final static int ALL_ON = 5;

	private int pointer = 0;

	public String[] getOffRoadNumbers() {
		return rotationTable[pointer];
	}

	void rotate() {
		pointer = ++pointer % 5;
	}

	public void setALL_ON() {
		pointer = ALL_ON;
	}

}
