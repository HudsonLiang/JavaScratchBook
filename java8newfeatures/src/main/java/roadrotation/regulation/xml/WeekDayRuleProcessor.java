package roadrotation.regulation.xml;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import roadrotation.regulation.WeekDayRule;

public class WeekDayRuleProcessor implements XmlRuleProcessor {

	@Override
	public Stream<WeekDayRule> apply(Rules xmlRules) {
		return xmlRules.weekDayRules.stream().flatMap(
				(xmlRule) -> {

					AtomicInteger i = new AtomicInteger(0);

					LocalDate startDate = xmlRule.getOnDate()
							.toGregorianCalendar().toZonedDateTime()
							.toLocalDate();

					return xmlRule
							.getWeekDaySequence()
							.stream()
							.map((numbersequence) -> {
								WeekDayRule wdRule = new WeekDayRule();

								int offset = i.getAndIncrement();

								wdRule.setEffectiveDate(startDate
										.plusDays(offset));

								return wdRule;
							});

				});

	}

}
