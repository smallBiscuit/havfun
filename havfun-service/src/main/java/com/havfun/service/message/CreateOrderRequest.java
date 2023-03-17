package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderBaseMessage;

public class CreateOrderRequest extends AbstractRequest{
	
	private OrderBaseMessage orderMessage;
	
	public CreateOrderRequest() {
		setMessageId(MessageId.CREATE_ORDER_REQUEST);
	}

	public OrderBaseMessage getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(OrderBaseMessage orderMessage) {
		this.orderMessage = orderMessage;
	}

	@Override
	public String toString() {
		return "CreateOrderRequest [orderMessage=" + orderMessage + ", clientId=" + clientId + ", token=" + token
				+ ", messageId=" + messageId + "]";
	}

	


}
