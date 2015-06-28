package taxproblem;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int id;
	private List<Item> items = new ArrayList<Item>();

	public Order(int id) {
		this.id = id;
	}


	public void addItem(final Item item) {
		this.items.add(item);
		System.out.printf("%1$d %2$s at %3$.2f\n", item.getAmount(), item.getGoods(), item.getUnitCost());
	}
	
	public Item[] getItems(){
		
		Item[] itemArray = new Item[items.size()];
		return items.toArray(itemArray);
	}

	public int getId() {
		return id;
	}

}
