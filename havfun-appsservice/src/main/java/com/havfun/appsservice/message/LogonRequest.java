package com.havfun.appsservice.message;

public class LogonRequest {

	private String userName;
	
	private String userPasscode;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasscode() {
		return userPasscode;
	}

	public void setUserPasscode(String userPasscode) {
		this.userPasscode = userPasscode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogonRequest [userName=");
		builder.append(userName);
		builder.append(", userPasscode=");
		builder.append(userPasscode);
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}


	
}
