package roadrotation.regulation;

import java.time.LocalDate;

import roadrotation.Transition;

public class WeekDayRule implements Rule {

	private LocalDate effectiveDate;
	private String[] onRoadNumbers;

	@Override
	public Transition[] apply() {
		// TODO Auto-generated method stub
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
