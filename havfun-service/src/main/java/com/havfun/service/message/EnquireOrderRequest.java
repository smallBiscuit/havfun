package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class EnquireOrderRequest extends AbstractRequest {
	
	private int orderId;
	
	public EnquireOrderRequest() {
		setMessageId(MessageId.ENQUIRE_ORDER_REQUEST);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "EnquireOrderRequest [orderId=" + orderId + ", clientId=" + clientId + ", token=" + token
				+ ", messageId=" + messageId + "]";
	}


	
}
