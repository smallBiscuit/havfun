package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class UpdateClientAddressResponse extends AbstractResponse{

	public UpdateClientAddressResponse() {
		setMessageId(MessageId.UPDATE_CLIENT_ADDRESS_RESPONSE);
	}

	@Override
	public String toString() {
		return "UpdateClientAddressResponse [result=" + result + ", messageId=" + messageId + "]";
	}
	
}
