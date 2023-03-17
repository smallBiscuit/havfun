package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class UpdateOrderRequest extends AbstractRequest{
	
	private OrderMessage orderMessage;
	
	public UpdateOrderRequest() {
		setMessageId(MessageId.UPDATE_ORDER_REQUEST);
	}

	public OrderMessage getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(OrderMessage orderMessage) {
		this.orderMessage = orderMessage;
	}

	@Override
	public String toString() {
		return "UpdateOrderRequest [orderMessage=" + orderMessage + ", clientId=" + clientId + ", token=" + token
				+ ", messageId=" + messageId + "]";
	}



}
