package com.havfun.service.message.admin.user;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchUserRequest extends BaseAdminRequest {
	
	public AdminSearchUserRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_USER_REQUEST);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchUserRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
