package com.havfun.service.message.admin.client;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ClientMessage;

public class AdminEnquireClientResponse extends AbstractResponse {
	
	private ClientMessage clientMessage;
	
	public AdminEnquireClientResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_CLIENT_RESPONSE);
	}

	public ClientMessage getClientMessage() {
		return clientMessage;
	}

	public void setClientMessage(ClientMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireClientResponse [clientMessage=");
		builder.append(clientMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
