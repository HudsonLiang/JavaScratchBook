package roadrationing.regulation;

import java.time.LocalDateTime;

public class ApplicableRule {

	private NumberCombination numbersOffRoad;
	private LocalDateTime start;
	private LocalDateTime end;

	public ApplicableRule(NumberCombination numbersOffRoad, LocalDateTime start, LocalDateTime end) {

		this.numbersOffRoad = numbersOffRoad;
		this.start = start;
		this.end = end;
	}

	
	public NumberCombination getNumbersOffRoad() {
		return numbersOffRoad;
	}



	public LocalDateTime getStart() {
		return start;
	}



	public LocalDateTime getEnd() {
		return end;
	}



}
