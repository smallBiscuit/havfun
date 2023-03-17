package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class EnquireSystemDataRequest extends AbstractRequest{

	public EnquireSystemDataRequest() {
		setMessageId(MessageId.ENQUIRE_SYSTEM_DATA_REQUEST);
	}
	
	@Override
	public String toString() {
		return "EnquireSystemDataRequest [clientId=" + clientId + ", token=" + token + ", messageId=" + messageId + "]";
	}

	
}
