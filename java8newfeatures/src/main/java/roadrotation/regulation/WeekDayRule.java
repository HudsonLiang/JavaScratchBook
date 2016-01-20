package roadrotation.regulation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

import roadrotation.NumberCombination;

public class WeekDayRule implements Rule {

	private LocalDate effectiveDate;
	private String[] onRoadNumbers;

	@Override
	public SortedMap<LocalDateTime, NumberCombination> apply(
			LocalDateTime instant) {

		LocalDateTime starttime = effectiveDate.atTime(7, 0);
		LocalDateTime endtime = effectiveDate.atTime(20, 0);

		SortedMap<LocalDateTime, NumberCombination> transitions = new TreeMap<LocalDateTime, NumberCombination>();
		// if instant is before 8am effectiveDate, at starttime should transit
		// to limited numbers
		if (starttime.isAfter(instant) || starttime.isEqual(instant))
			transitions.put(starttime,
					NumberCombination.getInstance(onRoadNumbers));
		// if instant is in the middle of day, at endtime, should transit to all
		if (endtime.isAfter(instant) || endtime.isEqual(instant))
			transitions.put(starttime,
					NumberCombination.getInstance(onRoadNumbers));
		transitions.put(endtime, NumberCombination.ALL);

		return transitions;

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

	@Override
	public int hashCode() {
		int result = 17;

		return 31 * (31 * result + effectiveDate.hashCode())
				+ Arrays.hashCode(onRoadNumbers);

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof WeekDayRule))
			return false;

		WeekDayRule compare = (WeekDayRule) obj;

		return this.effectiveDate.isEqual(compare.effectiveDate)
				&& Arrays.equals(this.onRoadNumbers, compare.onRoadNumbers);
	}

}