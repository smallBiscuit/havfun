package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminChangePasscodeResponse extends AbstractResponse {
	
	public AdminChangePasscodeResponse() {
		setMessageId(MessageId.ADMIN_CHANGE_PASSCODE_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminChangePasswordResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
