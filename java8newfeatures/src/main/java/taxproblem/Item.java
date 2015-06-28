package taxproblem;

import java.math.BigDecimal;

public class Item {

	private BigDecimal unitCost;
	private int amount;
	private Goods goods;

	public Item(BigDecimal unitCost, int account, Goods goods) {

		this.unitCost = unitCost;
		this.amount = account;
		this.goods = goods;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}



}
