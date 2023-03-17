package com.havfun.service.message.admin.user;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.UserMessage;

public class AdminEnquireUserResponse extends AbstractResponse {
	
	private UserMessage userMessage;
	
	public AdminEnquireUserResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_USER_RESPONSE);
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
		builder.append("AdminEnquireUserResponse [userMessage=");
		builder.append(userMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
