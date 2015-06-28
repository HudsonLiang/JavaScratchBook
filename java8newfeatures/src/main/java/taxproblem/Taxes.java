package taxproblem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class Taxes {

	public static Function<Item, BigDecimal> basicSalesTax() {

		return (item) -> {
			BigDecimal taxRate = BigDecimal.ZERO;
			if (!item.getGoods().isFood()) {
				taxRate = new BigDecimal("0.10");
			}

			return calculateTax(item, taxRate);
		};

	}

	public static Function<Item, BigDecimal> importTax() {
		return (item) -> {

			BigDecimal taxRate = BigDecimal.ZERO;

			if (item.getGoods().isImported()) {
				taxRate = new BigDecimal("0.05");
			}

			return calculateTax(item, taxRate);

		};
	}

	private static BigDecimal calculateTax(Item item, BigDecimal taxrate) {

		BigDecimal input = item.getUnitCost().multiply(new BigDecimal(item.getAmount())).multiply(taxrate);

		BigDecimal twoDecimal = input.setScale(2, RoundingMode.UP);
		int lastDigit = twoDecimal.multiply(new BigDecimal(100)).remainder(new BigDecimal(10)).intValue();
		
		while(lastDigit != 0 && lastDigit != 5 && lastDigit != 10){
			twoDecimal = twoDecimal.add(new BigDecimal("0.01"));
			lastDigit++;
		}
		

		return twoDecimal;
	}

}
