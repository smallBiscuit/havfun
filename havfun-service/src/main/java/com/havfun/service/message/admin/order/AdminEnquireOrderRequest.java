package com.havfun.service.message.admin.order;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireOrderRequest extends BaseAdminRequest {
	
	private int clientId;
	
	public AdminEnquireOrderRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_ORDER_REQUEST);
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
		builder.append("AdminEnquireOrderRequest [clientId=");
		builder.append(clientId);
		builder.append(", loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
