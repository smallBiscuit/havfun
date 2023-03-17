package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminResetPasscodeRequest extends AbstractRequest {

	private int userId;
	
	private String userLoginId;
	
	private String userEmail;
	
	public AdminResetPasscodeRequest() {
		setMessageId(MessageId.ADMIN_RESET_PASSCODE_REQUEST);
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
		builder.append("AdminResetPasscodeRequest [userId=");
		builder.append(userId);
		builder.append(", userLoginId=");
		builder.append(userLoginId);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
