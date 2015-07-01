package taxproblem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import taxproblem.Goods;
import taxproblem.Item;
import taxproblem.Order;

public class OrderProcessorTest {

	private Order orderToTest;

	@Before
	public void setup() {

		orderToTest = new Order(1);
		Item item = new Item(BigDecimal.ZERO, 1, Goods.CD);
		orderToTest.addItem(item);

	}

	@Test
	public void testStream() {

		assertEquals(1, Arrays.stream(orderToTest.getItems()).count());
		Arrays.stream(orderToTest.getItems()).forEach(item->System.out.println(item.getGoods()));
	}

}
