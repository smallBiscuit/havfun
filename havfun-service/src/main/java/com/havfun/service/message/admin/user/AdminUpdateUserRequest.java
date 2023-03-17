package com.havfun.service.message.admin.user;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.UserMessage;

public class AdminUpdateUserRequest extends BaseAdminRequest{
	
	private UserMessage userMessage;
	
	public AdminUpdateUserRequest() {
		setMessageId(MessageId.ADMIN_UPDATE_USER_REQUEST);
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
		builder.append("AdminUpdateUserRequest [userMessage=");
		builder.append(userMessage);
		builder.append(", loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
