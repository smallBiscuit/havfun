package com.havfun.service.message.admin.client;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateClientResponse extends AbstractResponse {
	
	public AdminUpdateClientResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_CLIENT_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateClientResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
