package com.havfun.service.message.admin.client;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ClientMessage;

public class AdminCreateClientRequest extends BaseAdminRequest{
	
	private ClientMessage clientMessage;
	
	public AdminCreateClientRequest() {
		setMessageId(MessageId.ADMIN_CREATE_CLIENT_REQUEST);
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
		builder.append("AdminCreateClientRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}


}
