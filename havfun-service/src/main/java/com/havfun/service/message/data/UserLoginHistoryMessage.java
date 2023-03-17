package com.havfun.service.message.data;

import com.havfun.service.entity.constant.LoginStatus;
import com.havfun.service.message.AbstractMessage;
import com.havfun.service.message.constant.MessageId;

public class UserLoginHistoryMessage extends AbstractMessage {
	
private int userLoginHistoryId;
	
	private int userId;
	
	private String loginToken;
	
	private String ipAddress;
	
	private long loginTimestamp;
	
	private long logoutTimestamp;
	
	private LoginStatus loginStatus;
	
	public UserLoginHistoryMessage() {
		setMessageId(MessageId.USER_LOGIN_HISTORY_MESSAGE);
	}

	public int getUserLoginHistoryId() {
		return userLoginHistoryId;
	}

	public void setUserLoginHistoryId(int userLoginHistoryId) {
		this.userLoginHistoryId = userLoginHistoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		StringBuilder builder = new StringBuilder();
		builder.append("UserLoginHistoryMessage [userLoginHistoryId=");
		builder.append(userLoginHistoryId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", loginToken=");
		builder.append(loginToken);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", loginTimestamp=");
		builder.append(loginTimestamp);
		builder.append(", logoutTimestamp=");
		builder.append(logoutTimestamp);
		builder.append(", loginStatus=");
		builder.append(loginStatus);
		builder.append("]");
		return builder.toString();
	}

}
