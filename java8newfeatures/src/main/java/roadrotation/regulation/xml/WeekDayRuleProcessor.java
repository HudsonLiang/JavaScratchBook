package roadrotation.regulation.xml;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import java.util.stream.Stream.Builder;

import roadrotation.regulation.WeekDayRule;

public class WeekDayRuleProcessor implements XmlRuleProcessor {

	@Override
	public Stream<WeekDayRule> apply(Rules xmlRules) {
		return xmlRules.weekDayRules.stream().flatMap(
				(xmlRule) -> {

					LocalDate startDate = xmlRule.getOnDate()
							.toGregorianCalendar().toZonedDateTime()
							.toLocalDate();

					LocalDate endDate = xmlRule.getOffDate()
							.toGregorianCalendar().toZonedDateTime()
							.toLocalDate();

					Builder<LocalDate> weekDayStreamBuilder = Stream.builder();

					while (startDate.isBefore(endDate)
							|| startDate.isEqual(endDate)) {

						if (startDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
								|| startDate.getDayOfWeek().equals(
										DayOfWeek.SUNDAY))
							continue;

						weekDayStreamBuilder.accept(startDate);
						startDate = startDate.plusDays(1);
					}

					AtomicInteger i = new AtomicInteger(0);

					String[] numbersequence = xmlRule.getWeekDaySequence()
							.toArray(new String[0]);

					return weekDayStreamBuilder.build().map(
							weekDay -> {
								WeekDayRule wdRule = new WeekDayRule();

								int offset = i.getAndIncrement() % 5;

								wdRule.setEffectiveDate(weekDay);
								wdRule.setOnRoadNumbers(numbersequence[offset]
										.split(","));

								return wdRule;
							});

				});

	}
}
