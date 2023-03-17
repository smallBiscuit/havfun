package com.havfun.appsservice.message;

import com.havfun.appsservice.data.Order;

public class CheckoutResponse extends AbstractResponse{

	private int orderId;
	
	private Order order;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "CheckoutResponse [orderId=" + orderId + ", order=" + order + ", result=" + result + ", reason=" + reason
				+ "]";
	}
	

	
}
