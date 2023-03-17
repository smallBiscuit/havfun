package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class FirebaseLogonRequest extends AbstractRequest {

	private String userName;
	
	private String userPassword;
	
	private String socialSignInProvider;

	private String socialSignInIdentifier;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSocialSignInProvider() {
		return socialSignInProvider;
	}

	public void setSocialSignInProvider(String socialSignInProvider) {
		this.socialSignInProvider = socialSignInProvider;
	}

	public String getSocialSignInIdentifier() {
		return socialSignInIdentifier;
	}

	public void setSocialSignInIdentifier(String socialSignInIdentifier) {
		this.socialSignInIdentifier = socialSignInIdentifier;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogonRequest [userName=");
		builder.append(userName);
		builder.append(", userPassword=");
		builder.append(userPassword);
		builder.append(", socialSignInProvider=");
		builder.append(socialSignInProvider);
		builder.append(", socialSignInIdentifier=");
		builder.append(socialSignInIdentifier);
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