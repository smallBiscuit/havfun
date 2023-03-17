package com.havfun.service.message.admin.user;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateUserResponse extends AbstractResponse {
	
	public AdminUpdateUserResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_USER_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateUserResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
