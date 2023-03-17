package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class UpdateClientResponse extends AbstractResponse {
	
	public UpdateClientResponse() {
		setMessageId(MessageId.UPDATE_CLIENT_RESPONSE);
	}

	@Override
	public String toString() {
		return "UpdateClientResponse [result=" + result + ", messageId=" + messageId + "]";
	}
	
}

