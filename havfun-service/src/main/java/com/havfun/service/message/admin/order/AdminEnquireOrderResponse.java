package com.havfun.service.message.admin.order;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class AdminEnquireOrderResponse extends AbstractResponse {
	
	private OrderMessage clientMessage;
	
	public AdminEnquireOrderResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_ORDER_RESPONSE);
	}

	public OrderMessage getOrderMessage() {
		return clientMessage;
	}

	public void setOrderMessage(OrderMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireOrderResponse [clientMessage=");
		builder.append(clientMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
