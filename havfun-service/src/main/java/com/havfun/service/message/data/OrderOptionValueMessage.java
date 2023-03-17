package com.havfun.service.message.data;

public class OrderOptionValueMessage {

	private int orderOptionValueId;
	
	private int orderOptionId;
	
	private int sortingOrder;

	public int getOrderOptionValueId() {
		return orderOptionValueId;
	}

	public void setOrderOptionValueId(int orderOptionValueId) {
		this.orderOptionValueId = orderOptionValueId;
	}

	public int getOrderOptionId() {
		return orderOptionId;
	}

	public void setOrderOptionId(int orderOptionId) {
		this.orderOptionId = orderOptionId;
	}

	public int getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(int sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	@Override
	public String toString() {
		return "OrderOptionValue [orderOptionValueId=" + orderOptionValueId + ", orderOptionId=" + orderOptionId
				+ ", sortingOrder=" + sortingOrder + "]";
	}
	
	
	
}
