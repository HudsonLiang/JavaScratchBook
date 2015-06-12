package taxproblem;

import java.math.BigDecimal;

public class Receipt {
	private Order order;

	private BigDecimal salesTax;
	private BigDecimal totalCost;

	public Receipt(Order order) {
		this.order = order;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public Order getOrder() {
		return order;
	};

}
