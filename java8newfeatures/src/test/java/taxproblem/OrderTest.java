package taxproblem;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import taxproblem.Goods;
import taxproblem.Item;
import taxproblem.Order;

public class OrderTest {
	private Order orderToTest;

	@Before
	public void setup() {

		orderToTest = new Order(1);
	}

	@Test
	public void testAddItem() {

		Item item = new Item(BigDecimal.ZERO, 1, Goods.CD);
		orderToTest.addItem(item);

		Assert.assertEquals(1, orderToTest.getItems().length);

	}

}
