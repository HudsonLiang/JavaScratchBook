package roadrotation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import roadrotation.regulation.xml.XMLParser;

public class Rotater {
	private TreeMap<LocalDateTime, NumberCombination> transitions = new TreeMap<LocalDateTime, NumberCombination>();
	private ScheduledExecutorService scheduler;

	private NumberCombination inEffectNumbers;

	public Rotater() {
		scheduler = new ScheduledThreadPoolExecutor(1);

	}

	public void init() {

		init(new File("resources/roadrotation.xml"), LocalDateTime.now());
	}

	void init(File xmlRuleFile, LocalDateTime instant) {
		XMLParser xmlParser = new XMLParser();
		xmlParser.setRuleFile(xmlRuleFile);

		xmlParser.parse().forEach(
				rule -> transitions.putAll(rule.apply(instant)));

	}

	public ScheduledFuture<LocalDateTime> schedule(LocalDateTime instant) {

		inEffectNumbers = transitions.floorEntry(instant) == null ? NumberCombination.ALL
				: transitions.floorEntry(instant).getValue();

		Callable<LocalDateTime> rotate = () -> {
			LocalDateTime currentTime = LocalDateTime.now();
			this.inEffectNumbers = transitions.floorEntry(currentTime).getValue();

			return null;
		};

		ScheduledFuture<LocalDateTime> futuresRotation = scheduler.schedule(
				() -> {
					schedule(LocalDateTime.now());
					return transitions.ceilingKey(instant);
				}, instant.until(transitions.ceilingKey(instant),
						ChronoUnit.SECONDS) + 1, TimeUnit.SECONDS);

		return futuresRotation;
	}

	public NumberCombination getInEffectNumbers() {
		return inEffectNumbers;
	}

	TreeMap<LocalDateTime, NumberCombination> getTransitions() {
		return transitions;
	}

}
