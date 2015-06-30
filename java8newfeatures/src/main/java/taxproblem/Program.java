package taxproblem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		List<Order> orders = input();

		System.out.println("\nOUTPUT:\n");
		orders.forEach(order -> new OrderProcessor().process(order));

	}

	private static List<Order> input() {
		System.out.println("\nINPUT:\n");

		List<Order> orders = new ArrayList<Order>();

		int i = 1;
		Order order = new Order(i++);

		order.addItem(new Item(new BigDecimal("12.49"), 1, Goods.BOOK));
		order.addItem(new Item(new BigDecimal("14.99"), 1, Goods.CD));
		order.addItem(new Item(new BigDecimal("0.85"), 1, Goods.CHOCOLATE));

		orders.add(order);

		/*
		 * 1 imported box of chocolates at 10.00 
		 * 1 imported bottle of perfume at 47.50
		 */
		order = new Order(i++);

		order.addItem(new Item(new BigDecimal("10.00"), 1,
				Goods.IMPORTED_CHOCOLATE));
		order.addItem(new Item(new BigDecimal("47.50"), 1,
				Goods.IMPORTED_PERFUME));

		orders.add(order);

		/*
		 * Input 3: 
		 * 1 imported bottle of perfume at 27.99 
		 * 1 bottle of perfume at 18.99 
		 * 1 packet of headache pills at 9.75 
		 * 1 box of imported chocolates at 11.25
		 */
		order = new Order(i++);

		order.addItem(new Item(new BigDecimal("27.99"), 1,
				Goods.IMPORTED_PERFUME));
		order.addItem(new Item(new BigDecimal("18.99"), 1,
				Goods.PERFUME));
		order.addItem(new Item(new BigDecimal("9.75"), 1,
				Goods.PILL));
		order.addItem(new Item(new BigDecimal("11.25"), 1,
				Goods.IMPORTED_CHOCOLATE));

		orders.add(order);
		return orders;
	}
}
