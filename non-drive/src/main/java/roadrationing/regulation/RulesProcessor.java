package roadrationing.regulation;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RulesProcessor {
	
	/**
	 * The {@code ApplicableRule} that is in effect NOW.
	 * @return
	 */
	Optional<ApplicableRule> findEffectiveRules(LocalDateTime when);

}
