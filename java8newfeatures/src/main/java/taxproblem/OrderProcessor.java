package taxproblem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderProcessor {

	public void process(Order order) {

		List<BigDecimal> taxesToCollect = new ArrayList<BigDecimal>();
		List<BigDecimal> totalValues = new ArrayList<BigDecimal>();

		Arrays.stream(order.getItems()).forEach(
				item -> {
					System.out.println(item.toString());

					taxesToCollect.add(Taxes.basicSalesTax().apply(item));
					taxesToCollect.add(Taxes.importTax().apply(item));
					totalValues.add(item.getUnitCost().multiply(
							new BigDecimal(item.getAccount())));

				});

		double taxTotal = taxesToCollect.stream()
				.mapToDouble(bi -> bi.doubleValue()).sum();

		double costTotal = totalValues.stream()
				.mapToDouble(bi -> bi.doubleValue()).sum();

		System.out.printf("Sales Taxes: %1$.2f \nTotal: %2$.2f", taxTotal,
				taxTotal + costTotal);

	}
}
