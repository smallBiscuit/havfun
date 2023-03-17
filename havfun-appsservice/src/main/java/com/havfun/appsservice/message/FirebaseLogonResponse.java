package com.havfun.appsservice.message;

import com.havfun.appsservice.data.Client;

public class FirebaseLogonResponse extends AbstractResponse {

	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "FirebaseLogonResponse [client=" + client + ", result=" + result + ", reason=" + reason + "]";
	}

	
}

