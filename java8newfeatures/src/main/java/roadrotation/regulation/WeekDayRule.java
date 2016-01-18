package roadrotation.regulation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import roadrotation.NumberCombination;
import roadrotation.Transition;

public class WeekDayRule implements Rule {

	private LocalDate effectiveDate;
	private String[] onRoadNumbers;

	@Override
	public Transition apply(LocalDateTime instant) {

		LocalDateTime starttime = effectiveDate.atTime(7, 0);
		LocalDateTime endtime = effectiveDate.atTime(20, 0);
		// if instant is before 8am effectiveDate, at starttime should transit
		// to limited numbers
		if (starttime.isAfter(instant) || starttime.isEqual(instant))
			return new Transition(starttime,
					NumberCombination.getInstance(onRoadNumbers));
		// if instant is in the middle of day, at endtime, should transit to all
		else if (endtime.isEqual(instant) || endtime.isAfter(instant)
				&& starttime.isBefore(instant)) {
			return new Transition(endtime, NumberCombination.ALL);
		} else {
			// if instant is after endtime, no transition
			return null;
		}

	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String[] getOnRoadNumbers() {
		return onRoadNumbers;
	}

	public void setOnRoadNumbers(String[] onRoadNumbers) {
		this.onRoadNumbers = onRoadNumbers;
	}

}
