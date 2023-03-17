package com.havfun.service.message.admin.client;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateClientResponse extends AbstractResponse {
	
	private int clientId;
	
	public AdminCreateClientResponse() {
		setMessageId(MessageId.ADMIN_CREATE_CLIENT_RESPONSE);
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
		builder.append("AdminCreateClientResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
