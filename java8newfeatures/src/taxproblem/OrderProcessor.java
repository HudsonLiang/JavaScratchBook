package taxproblem;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BiFunction;

public class OrderProcessor {

	public BigDecimal[] process(Order order) {

		BigDecimal[] result = { BigDecimal.ZERO, BigDecimal.ZERO };

		Arrays.stream(order.getItems()).m,
				(a, b) -> {
					a[0] = a[0].add(b[0]);
					a[1] = a[1].add(b[1]);

					return a;
				});

		return result;
	}
}
