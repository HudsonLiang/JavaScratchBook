package taxproblem;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Item> items = new ArrayList<Item>();

	public void addItem(final Item item) {
		this.items.add(item);
	}
	
	public Item[] getItems(){
		return (Item[]) items.toArray();
	}

}
