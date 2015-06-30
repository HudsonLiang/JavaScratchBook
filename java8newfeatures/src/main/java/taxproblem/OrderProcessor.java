package taxproblem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderProcessor {

	public void process(Order order) {
		System.out.printf("\nOutput %1$d:\n", order.getId());

		List<Double> orderTax = new ArrayList<Double>();
		List<Double> orderCost = new ArrayList<Double>();

		Arrays.stream(order.getItems())
				.forEach(
						(item) -> {
							List<BigDecimal> taxesToCollect = new ArrayList<BigDecimal>();

							taxesToCollect.add(Taxes.basicSalesTax()
									.apply(item));
							taxesToCollect.add(Taxes.importTax().apply(item));

							double itemTax = taxesToCollect.stream()
									.mapToDouble(bi -> bi.doubleValue()).sum();

							double itemCost = item.getUnitCost()
									.multiply(new BigDecimal(item.getAmount()))
									.doubleValue()
									+ itemTax;

							System.out.printf("%1$d %2$s: %3$.2f\n",
									item.getAmount(), item.getGoods(), itemCost);

							orderTax.add(new Double(itemTax));
							orderCost.add(new Double(itemCost));

						});

		System.out.printf("Sales Taxes: %1$.2f \nTotal: %2$.2f\n", orderTax
				.stream().mapToDouble(d -> d).sum(), orderCost.stream()
				.mapToDouble(d -> d).sum());

	}
}
