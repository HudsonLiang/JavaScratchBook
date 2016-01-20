package roadrotation;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

import org.junit.Test;

public class RotaterTest {

	@Test
	public void testSchedule() throws InterruptedException, ExecutionException {

		LocalDateTime middaytime = LocalDateTime.of(2015, 4, 13, 14, 26, 0);
		LocalDateTime evening = LocalDateTime.of(2015, 4, 13, 21, 0, 0);
		LocalDateTime morning = LocalDateTime.of(2015, 4, 13, 1, 25, 0);
		LocalDateTime inTheEnd = LocalDateTime.of(2015, 4, 21, 8, 0, 0);

		Rotater rotater = new Rotater();
		rotater.init(new File("src/test/resources/roadrotation.xml"),
				middaytime);

		long delay = rotater.rotateAt(morning);
		assertEquals(NumberCombination.ALL, rotater.getInEffectNumbers());
		assertEquals(60 * 60 * (7 - 1) - 60 * 25 - 1, delay);

		delay = rotater.rotateAt(middaytime);
		assertEquals(NumberCombination.ONE_SIX, rotater.getInEffectNumbers());
		assertEquals((20 - 14) * 60 * 60 - 60 * 26 - 1, delay);

		delay = rotater.rotateAt(evening);
		assertEquals(NumberCombination.ALL, rotater.getInEffectNumbers());
		assertEquals(60 * 60 * (24 - 21 + 7) - 1, delay);
		
		delay = rotater.rotateAt(inTheEnd);
		assertEquals(NumberCombination.ALL, rotater.getInEffectNumbers());
		assertEquals(0, delay);

	}

}
