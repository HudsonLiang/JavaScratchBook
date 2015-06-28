package taxproblem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		List<Order> orders = input();

		System.out.println("OUTPUT:");
		orders.forEach(order -> new OrderProcessor().process(order));

	}

	private static List<Order> input() {
		System.out.println("INPUT:");

		List<Order> orders = new ArrayList<Order>();

		int i = 1;
		Order order = new Order(i++);
		System.out.printf("Input %1$d\n", order.getId());
		order.addItem(new Item(new BigDecimal("12.49"), 1, Goods.BOOK));
		order.addItem(new Item(new BigDecimal("14.99"), 1, Goods.CD));
		order.addItem(new Item(new BigDecimal("0.85"), 1, Goods.CHOCOLATE));
		
		orders.add(order);

		return orders;
	}
}
