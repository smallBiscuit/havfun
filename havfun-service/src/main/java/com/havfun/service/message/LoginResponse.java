package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ClientMessage;

public class LoginResponse extends AbstractResponse {
	
	private ClientMessage client;
	
	public LoginResponse() {
		setMessageId(MessageId.LOGIN_RESPONSE);
	}

	public ClientMessage getClient() {
		return client;
	}

	public void setClient(ClientMessage client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "LoginResponse [client=" + client + ", result=" + result + ", messageId=" + messageId + "]";
	}

}

