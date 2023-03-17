package com.havfun.appsservice.data;

public class BaseClient {

	private int clientId;
	
	private String email;
	
	private String token;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "BaseClient [clientId=" + clientId + ", email=" + email + ", token=" + token + "]";
	}
	
	
	
}
