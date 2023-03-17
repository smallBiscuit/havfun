package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class CreateClientResponse extends AbstractResponse{

	private int clientId;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	public CreateClientResponse() {
		setMessageId(MessageId.CREATE_CLIENT_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateClientResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
