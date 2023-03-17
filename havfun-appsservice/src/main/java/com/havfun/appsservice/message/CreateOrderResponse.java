package com.havfun.appsservice.message;

public class CreateOrderResponse extends AbstractResponse{

	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateOrderResponse [orderId=");
		builder.append(orderId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
