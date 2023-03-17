package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminGeneratePasscodeResponse extends AbstractResponse {
	
	public AdminGeneratePasscodeResponse() {
		setMessageId(MessageId.ADMIN_GENERATE_PASSCODE_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminGeneratePasscodeResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
