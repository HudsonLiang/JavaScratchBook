package roadrationing.regulation.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import roadrationing.regulation.ApplicableRule;
import roadrationing.regulation.NumberCombination;
import roadrationing.regulation.WeekDayRuleTypeProcessor;
import roadrationing.regulation.xml.WeekDayRuleType;

public class DefaultWeekdayRuleTypeProcessor implements WeekDayRuleTypeProcessor {

	@Override
	public Optional<ApplicableRule> findEffective(List<WeekDayRuleType> weekdayRules, LocalDate day) {

		LocalDateTime sameDay7AM = LocalDateTime.of(day, LocalTime.of(7, 0));

		LocalDateTime sameDay8PM = LocalDateTime.of(day, LocalTime.of(20, 0));

		Optional<WeekDayRuleType> weekDayRuleInEffect = weekdayRules.stream().filter(weekdayRule -> {
			GregorianCalendar onDate = weekdayRule.getOnDate().toGregorianCalendar();
			LocalDate dayOn = LocalDate.ofYearDay(onDate.get(Calendar.YEAR), onDate.get(Calendar.DAY_OF_YEAR));

			GregorianCalendar offDate = weekdayRule.getOffDate().toGregorianCalendar();
			LocalDate dayOff = LocalDate.ofYearDay(offDate.get(Calendar.YEAR), offDate.get(Calendar.DAY_OF_YEAR));

			return (day.compareTo(dayOn) >= 0 && day.compareTo(dayOff) <= 0);

		}).findFirst();

		if (weekDayRuleInEffect.isPresent()) {

			List<String> offRoadNumbers = weekDayRuleInEffect.get().getWeekDaySequence();

			DayOfWeek dayOfWeek = day.getDayOfWeek();

			switch (dayOfWeek) {
			case SATURDAY:
			case SUNDAY:
				break;
			default:

				String numberCombination = offRoadNumbers.get(dayOfWeek.getValue() - 1);
				String[] numbers = StringUtils.split(numberCombination,',');

				return Optional.of(new ApplicableRule(NumberCombination.getInstance(numbers), sameDay7AM, sameDay8PM));
			}

		}
		return Optional.empty();
	}

}
