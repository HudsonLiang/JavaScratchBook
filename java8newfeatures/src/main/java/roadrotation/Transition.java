package roadrotation;

import java.time.LocalDateTime;

public class Transition {

	private LocalDateTime transitionTime;
	private NumberCombination numberCombination;

	public Transition(LocalDateTime transitionTime,
			NumberCombination numberCombination) {
		this.transitionTime = transitionTime;
		this.numberCombination = numberCombination;
	}

}
