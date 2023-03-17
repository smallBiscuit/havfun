package com.havfun.service.message.admin.user;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.UserMessage;

public class AdminSearchUserResponse extends AbstractResponse {
	
	private List<UserMessage> userMessageList;
	
	public AdminSearchUserResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_USER_RESPONSE);
	}

	public List<UserMessage> getUserMessageList() {
		return userMessageList;
	}

	public void setUserMessageList(List<UserMessage> userMessageList) {
		this.userMessageList = userMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchUserResponse [userMessageList=");
		builder.append(userMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
