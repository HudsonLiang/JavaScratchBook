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

	public int getAccount() {
		return amount;
	}

	public void setAccount(int account) {
		this.amount = account;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
