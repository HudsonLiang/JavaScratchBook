package roadrotation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import roadrotation.regulation.xml.XMLParser;

public class Rotater {
	private TreeMap<LocalDateTime, NumberCombination> transitions = new TreeMap<LocalDateTime, NumberCombination>();
	private ScheduledExecutorService scheduler;

	private NumberCombination inEffectNumbers;
	private ScheduledFuture<Long> nextTransition;

	public Rotater() {
		scheduler = new ScheduledThreadPoolExecutor(1);

	}

	public void init() {

		init(new File("src/main/resources/roadrotation.xml"), LocalDateTime.now());
	}

	void init(File xmlRuleFile, LocalDateTime thisTime) {
		XMLParser xmlParser = new XMLParser();
		xmlParser.setRuleFile(xmlRuleFile);

		xmlParser.parse().forEach(
				rule -> transitions.putAll(rule.apply(thisTime)));
	}

	public NumberCombination getInEffectNumbers() {
		return inEffectNumbers;
	}


	public long rotateAt(LocalDateTime thisTime) {
		inEffectNumbers = transitions.floorEntry(thisTime) == null ? NumberCombination.ALL
				: transitions.floorEntry(thisTime).getValue();
		LocalDateTime nextRunTime = transitions.ceilingKey(thisTime);

		if (nextRunTime != null) {

			nextTransition = scheduler.schedule(() -> rotateAt(nextRunTime),
					thisTime.until(nextRunTime, ChronoUnit.SECONDS),
					TimeUnit.SECONDS);

			return nextTransition.getDelay(TimeUnit.SECONDS);
		}
		return 0;
	}
}
