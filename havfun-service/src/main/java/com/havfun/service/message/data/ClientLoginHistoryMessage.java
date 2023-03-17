package com.havfun.service.message.data;

import com.havfun.service.entity.constant.LoginStatus;

public class ClientLoginHistoryMessage {

	private int clientLoginHistoryId;
	
	private int clientId;
	
	private String loginToken;
	
	private String ipAddress;
	
	private long loginTimestamp;
	
	private long logoutTimestamp;
	
	private LoginStatus loginStatus;

	public int getClientLoginHistoryId() {
		return clientLoginHistoryId;
	}

	public void setClientLoginHistoryId(int clientLoginHistoryId) {
		this.clientLoginHistoryId = clientLoginHistoryId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getLoginTimestamp() {
		return loginTimestamp;
	}

	public void setLoginTimestamp(long loginTimestamp) {
		this.loginTimestamp = loginTimestamp;
	}

	public long getLogoutTimestamp() {
		return logoutTimestamp;
	}

	public void setLogoutTimestamp(long logoutTimestamp) {
		this.logoutTimestamp = logoutTimestamp;
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "ClientLoginHistory [clientLoginHistoryId=" + clientLoginHistoryId + ", clientId=" + clientId
				+ ", loginToken=" + loginToken + ", ipAddress=" + ipAddress + ", loginTimestamp=" + loginTimestamp
				+ ", logoutTimestamp=" + logoutTimestamp + ", loginStatus=" + loginStatus + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
