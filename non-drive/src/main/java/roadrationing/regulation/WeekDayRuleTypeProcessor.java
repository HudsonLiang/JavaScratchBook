package roadrationing.regulation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import roadrationing.regulation.xml.WeekDayRuleType;

public interface WeekDayRuleTypeProcessor {

	Optional<ApplicableRule> findEffective(List<WeekDayRuleType> weekdayRules, LocalDate day);

}
