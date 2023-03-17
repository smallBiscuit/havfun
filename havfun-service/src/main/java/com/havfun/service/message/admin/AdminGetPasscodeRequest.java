package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminGetPasscodeRequest extends AbstractRequest {
	
	private int userId;
	
	private String userLoginId;
	
	private String userEmail;
	
	public AdminGetPasscodeRequest() {
		setMessageId(MessageId.ADMIN_GET_PASSCODE_REQUEST);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminGetPasscode [userId=");
		builder.append(userId);
		builder.append(", userLoginId=");
		builder.append(userLoginId);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append("]");
		return builder.toString();
	}

}
