package com.havfun.service.message.admin.client;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireClientRequest extends BaseAdminRequest {
	
	private int clientId;
	
	public AdminEnquireClientRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_CLIENT_REQUEST);
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireClientRequest [clientId=");
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
