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
		Rotater rotater = new Rotater();
		rotater.init(new File(
				"java8newfeatures/src/test/resources/roadrotation.xml"),
				LocalDateTime.of(2015, 4, 13, 14, 26, 0));

		ScheduledFuture<LocalDateTime> futureTransition = rotater
				.schedule(LocalDateTime.of(2015, 4, 13, 14, 26, 0));

		assertEquals(LocalDateTime.of(2015, 4, 13, 20, 0, 0),
				futureTransition.get());
	}

}
