package com.havfun.service.message.admin.user;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateUserResponse extends AbstractResponse {
	
	private int userId;
	
	public AdminCreateUserResponse() {
		setMessageId(MessageId.ADMIN_CREATE_USER_RESPONSE);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminCreateUserResponse [userId=");
		builder.append(userId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
