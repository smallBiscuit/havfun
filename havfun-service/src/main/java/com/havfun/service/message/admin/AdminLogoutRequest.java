package com.havfun.service.message.admin;

import com.havfun.service.message.constant.MessageId;

public class AdminLogoutRequest extends BaseAdminRequest {
	
	public AdminLogoutRequest() {
		setMessageId(MessageId.ADMIN_LOGOUT_REQUEST);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminLogoutRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

	
}
