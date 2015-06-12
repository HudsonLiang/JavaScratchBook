package taxproblem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Taxes {

	public static Function<Item, BigDecimal[]> basicSalesTax() {

		return (item) -> {
			BigDecimal taxRate = BigDecimal.ZERO;
			if (!item.getGoods().isFood()) {
				taxRate = new BigDecimal("0.10");
			}

			BigDecimal taxOfItem = roundUp(item.getUnitCost().mr[1].multiply(taxRate));

			r[1] = r[1].add(taxOfItem);
			return r;

		};

	}

	public static BiFunction<BigDecimal[], Item, BigDecimal[]> importTax() {
		return (r, item) -> {

			BigDecimal taxRate = BigDecimal.ZERO;

			if (item.getGoods().isImported()) {
				taxRate = new BigDecimal("0.05");
			}

			BigDecimal taxOfItem = roundUp(r[1].multiply(taxRate));
			r[1] = r[1].add(taxOfItem);
			return r;

		};
	}

	private static BigDecimal roundUp(BigDecimal input) {


		BigDecimal twoDecimal = input.setScale(2, RoundingMode.UP);
		int lastDigit = twoDecimal.multiply(new BigDecimal(100)).remainder(new BigDecimal(10)).intValue();
		
		while(lastDigit != 0 && lastDigit != 5){
			twoDecimal.add(new BigDecimal("0.01"));
			lastDigit++;
		}
		

		return twoDecimal;
	}

}
