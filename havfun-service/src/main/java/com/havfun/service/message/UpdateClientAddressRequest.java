package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.AddressMessage;

public class UpdateClientAddressRequest extends AbstractRequest{

	private AddressMessage addressMessage;
	
	public UpdateClientAddressRequest() {
		setMessageId(MessageId.UPDATE_CLIENT_ADDRESS_REQUEST);
	}

	public AddressMessage getAddressMessage() {
		return addressMessage;
	}

	public void setAddressMessage(AddressMessage addressMessage) {
		this.addressMessage = addressMessage;
	}

	@Override
	public String toString() {
		return "UpdateClientAddressRequest [addressMessage=" + addressMessage + ", clientId=" + clientId + ", token="
				+ token + ", messageId=" + messageId + "]";
	}


	
	
}
