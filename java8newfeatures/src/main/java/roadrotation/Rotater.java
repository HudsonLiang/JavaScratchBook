package roadrotation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import roadrotation.regulation.xml.XMLParser;

public class Rotater {
	private TreeMap<LocalDateTime, NumberCombination> transitions;
	private ScheduledExecutorService schedulerService;

	private NumberCombination inEffectNumbers;

	public void registerSchedule() {

		schedulerService = new ScheduledThreadPoolExecutor(1);
	}

	public void init() {

		XMLParser xmlParser = new XMLParser();
		xmlParser.setRuleFile(new File("resources/roadrotation.xml"));

		xmlParser.parse().forEach(
				rule -> transitions.putAll(rule.apply(LocalDateTime.now())));

		schedule(LocalDateTime.now());

	}

	public void schedule(LocalDateTime instant) {

		inEffectNumbers = transitions.floorEntry(instant) == null ? NumberCombination.ALL
				: transitions.floorEntry(instant).getValue();

		schedulerService.schedule(() -> this.schedule(LocalDateTime.now()),
				instant.until(transitions.ceilingKey(instant),
						ChronoUnit.SECONDS) + 1, TimeUnit.SECONDS);
	}

	public NumberCombination getInEffectNumbers() {
		return inEffectNumbers;
	}

}
