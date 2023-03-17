package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminResetPasscodeResponse extends AbstractResponse {
	
	public AdminResetPasscodeResponse() {
		setMessageId(MessageId.ADMIN_RESET_PASSCODE_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminResetPasswordResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
