package roadrotaion;

public class Manager {

	private String[][] rotationTable = { { "0", "5" }, { "1", "6" },
			{ "2", "7" }, { "3", "8" }, { "4", "9" } };

	private int pointer = 0;

	public String[] getOffRoadNumbers() {
		return rotationTable[pointer];
	}
	
	private class Trigger{
		
		private void schedule(){
			
		}
		
	}

}
