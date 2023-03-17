package com.havfun.appsservice.message;

import com.havfun.service.entity.constant.OrderStatus;

public class UpdateOrderRequest extends AbstractRequest{

	private int orderId;
	
	private String paymentId;
	
	private OrderStatus orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateOrderRequest [orderId=");
		builder.append(orderId);
		builder.append(", paymentId=");
		builder.append(paymentId);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append("]");
		return builder.toString();
	}

	
	
}
