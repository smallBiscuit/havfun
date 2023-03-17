package com.havfun.service.message;

public abstract class AbstractRequest extends AbstractMessage {

	protected int clientId;
	
	protected String token;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
