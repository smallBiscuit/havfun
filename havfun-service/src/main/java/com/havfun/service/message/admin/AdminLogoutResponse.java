package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminLogoutResponse extends AbstractResponse {
	
	public AdminLogoutResponse() {
		setMessageId(MessageId.ADMIN_LOGOUT_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminLogoutResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
