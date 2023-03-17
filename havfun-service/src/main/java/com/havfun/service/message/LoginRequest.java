package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class LoginRequest extends AbstractRequest {
	
	private String email;
	
	private String password;
	
	private String socialLoginProvider;
	
	private String socialLoginIdentifier;
	
	public LoginRequest() {
		setMessageId(MessageId.LOGIN_REQUEST);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSocialLoginProvider() {
		return socialLoginProvider;
	}

	public void setSocialLoginProvider(String socialLoginProvider) {
		this.socialLoginProvider = socialLoginProvider;
	}

	public String getSocialLoginIdentifier() {
		return socialLoginIdentifier;
	}

	public void setSocialLoginIdentifier(String socialLoginIdentifier) {
		this.socialLoginIdentifier = socialLoginIdentifier;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginRequest [email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", socialLoginProvider=");
		builder.append(socialLoginProvider);
		builder.append(", socialLoginIdentifier=");
		builder.append(socialLoginIdentifier);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

	

	
}
