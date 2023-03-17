package com.havfun.service.message.admin.order;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateOrderResponse extends AbstractResponse {
	
	private int clientId;
	
	public AdminCreateOrderResponse() {
		setMessageId(MessageId.ADMIN_CREATE_ORDER_RESPONSE);
	}

	public int getOrderId() {
		return clientId;
	}

	public void setOrderId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminCreateOrderResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
