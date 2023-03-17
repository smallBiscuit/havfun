package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.UserMessage;

public class AdminLoginResponse extends AbstractResponse {
	
	private boolean changePassword;
	
	private UserMessage userMessage;
	
	private String token;
	
	public AdminLoginResponse() {
		setMessageId(MessageId.ADMIN_LOGIN_RESPONSE);
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AdminLoginResponse [changePassword="
				+ changePassword + ", userMessage=" + userMessage + ", token="
				+ token + ", result=" + result + ", messageId=" + messageId
				+ "]";
	}


}
