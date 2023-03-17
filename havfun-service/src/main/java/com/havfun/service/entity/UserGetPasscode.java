package com.havfun.service.entity;

import com.havfun.service.entity.constant.UserGetPasscodeStatus;

public class UserGetPasscode {
	
	private int userId;
	
	private String generatedToken;
	
	private long expiryTime;
	
	private UserGetPasscodeStatus userGetPasscodeStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGeneratedToken() {
		return generatedToken;
	}

	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

	public UserGetPasscodeStatus getUserGetPasscodeStatus() {
		return userGetPasscodeStatus;
	}

	public void setUserGetPasscodeStatus(UserGetPasscodeStatus userGetPasscodeStatus) {
		this.userGetPasscodeStatus = userGetPasscodeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserGetPasscode [userId=");
		builder.append(userId);
		builder.append(", generatedToken=");
		builder.append(generatedToken);
		builder.append(", expiryTime=");
		builder.append(expiryTime);
		builder.append(", userGetPasscodeStatus=");
		builder.append(userGetPasscodeStatus);
		builder.append("]");
		return builder.toString();
	}
	
}
