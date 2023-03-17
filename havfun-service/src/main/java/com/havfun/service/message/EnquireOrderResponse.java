package com.havfun.service.message;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class EnquireOrderResponse extends AbstractResponse {
	
	private OrderMessage clientMessage;
	
	public EnquireOrderResponse() {
		setMessageId(MessageId.ENQUIRE_ORDER_RESPONSE);
	}

	public OrderMessage getOrderMessage() {
		return clientMessage;
	}

	public void setOrderMessage(OrderMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		return "EnquireOrderResponse [clientMessage=" + clientMessage + ", result=" + result + ", messageId="
				+ messageId + "]";
	}

	

}
