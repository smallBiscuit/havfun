package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminLoginRequest extends AbstractRequest {
	
	private String userLoginId;
	
	private String passcode;
	
	private String ipAddress;
	
	public AdminLoginRequest() {
		setMessageId(MessageId.ADMIN_LOGIN_REQUEST);
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminLoginRequest [userLoginId=");
		builder.append(userLoginId);
		builder.append(", passcode=");
		builder.append(passcode);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
