package roadrotation.regulation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import roadrotation.Transition;

public class WeekDayRule implements Rule {

	private LocalDate effectiveDate;
	private String[] onRoadNumbers;

	@Override
	public Transition apply(LocalDateTime instant) {
		if (instant.isBefore(effectiveDate.atStartOfDay())
				|| instant.isAfter(effectiveDate.plusDays(1).atStartOfDay()))
			return null;
		return null;
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
