package roadrationing.functions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import com.google.inject.Inject;

import roadrationing.aop.EntryExitLog;
import roadrationing.regulation.ApplicableRule;
import roadrationing.regulation.RulesProcessor;

public class NumberAtTimeFunction implements Function<LocalDateTime, Set<String>> {

	private RulesProcessor rulesProcessor;

	@Inject
	NumberAtTimeFunction(RulesProcessor rulesProcessor) {

		this.rulesProcessor = rulesProcessor;
	}

	@EntryExitLog
	@Override
	public Set<String> apply(LocalDateTime t) {

		LocalDateTime when = t == null ? LocalDateTime.now(ZoneId.of("+8")) : t;

		Optional<ApplicableRule> rule = rulesProcessor.findEffectiveRules(when);
		if (rule.isPresent()) {

			return rule.get().getNumbersOffRoad().getNumbers();
		} else

			return Collections.emptySet();
	}

}
