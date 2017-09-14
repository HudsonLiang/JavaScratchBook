package roadrationing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.util.Modules;

import roadrationing.aop.AopModule;
import roadrationing.functions.FunctionsModule;
import roadrationing.functions.NumberAtTime;
import roadrationing.functions.NumberAtTimeFunction;
import roadrationing.functions.TestFunction;
import roadrationing.regulation.ProcessorModule;

public class InjectorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFunctionModule() {

		@SuppressWarnings("unchecked")
		Function<LocalDateTime, Set<String>> testFunction = Guice.createInjector(new FunctionsModule(), new ProcessorModule(), new AopModule())
				.getInstance(Key.get(Function.class, NumberAtTime.class));

		assertTrue(testFunction instanceof NumberAtTimeFunction);

		NumberAtTimeFunction theFunction = (NumberAtTimeFunction) testFunction;
		
		theFunction.apply(null);


	}

	@Test
	public void testTestModule() {

		@SuppressWarnings("unchecked")
		Function<LocalDateTime, Set<String>> functionInTest = Guice.createInjector(new TestModule())
				.getInstance(Key.get(Function.class, NumberAtTime.class));
		Set<String> results = functionInTest.apply(LocalDateTime.now());

		assertArrayEquals(TestFunction.numbers, results.toArray());
		results = null;

		@SuppressWarnings("unchecked")
		Function<LocalDateTime, Set<String>> functionInOverrideModule = Guice
				.createInjector(Modules.override(new FunctionsModule(), new ProcessorModule(), new AopModule()).with(new TestModule()))
				.getInstance(Key.get(Function.class, NumberAtTime.class));
		results = functionInOverrideModule.apply(LocalDateTime.now());

		assertArrayEquals(TestFunction.numbers, results.toArray());
	}

}
