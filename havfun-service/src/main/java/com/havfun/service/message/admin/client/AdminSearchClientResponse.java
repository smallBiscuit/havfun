package com.havfun.service.message.admin.client;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ClientMessage;

public class AdminSearchClientResponse extends AbstractResponse {
	
	private List<ClientMessage> clientMessageList;
	
	public AdminSearchClientResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_CLIENT_RESPONSE);
	}

	public List<ClientMessage> getClientMessageList() {
		return clientMessageList;
	}

	public void setClientMessageList(List<ClientMessage> clientMessageList) {
		this.clientMessageList = clientMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchClientResponse [clientMessageList=");
		builder.append(clientMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
