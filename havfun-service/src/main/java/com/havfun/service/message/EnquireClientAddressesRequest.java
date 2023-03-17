package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class EnquireClientAddressesRequest extends AbstractRequest{
	
	public EnquireClientAddressesRequest() {
		setMessageId(MessageId.ENQUIRE_CLIENT_ADDRESSES_REQUEST);
	}

	@Override
	public String toString() {
		return "EnquireClientAddressesRequest [clientId=" + clientId + ", token=" + token + ", messageId=" + messageId
				+ "]";
	}
	
	
}
