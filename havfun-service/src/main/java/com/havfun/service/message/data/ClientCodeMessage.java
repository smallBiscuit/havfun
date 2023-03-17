package com.havfun.service.message.data;

public class ClientCodeMessage {

	private int clientCodeId;
	
	private String clientCode;
	
	private int clientId;
	
	private boolean used;

	public int getClientCodeId() {
		return clientCodeId;
	}

	public void setClientCodeId(int clientCodeId) {
		this.clientCodeId = clientCodeId;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "ClientCode [clientCodeId=" + clientCodeId + ", clientCode=" + clientCode + ", clientId=" + clientId
				+ ", used=" + used + "]";
	}
	
	
}
