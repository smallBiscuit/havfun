package com.havfun.service.message.admin.client;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchClientRequest extends BaseAdminRequest {
	
	public AdminSearchClientRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_CLIENT_REQUEST);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchClientRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
