package com.havfun.service.message;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class CreateOrderResponse extends AbstractResponse {

	public CreateOrderResponse() {
		setMessageId(MessageId.CREATE_ORDER_RESPONSE);
	}
	
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
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}


}
