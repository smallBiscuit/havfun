package com.havfun.service.message.admin.user;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.UserMessage;

public class AdminCreateUserRequest extends BaseAdminRequest{
	
	private UserMessage userMessage;
	
	public AdminCreateUserRequest() {
		setMessageId(MessageId.ADMIN_CREATE_USER_REQUEST);
	}

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminCreateUserRequest [userMessage=");
		builder.append(userMessage);
		builder.append("]");
		return builder.toString();
	}


}
