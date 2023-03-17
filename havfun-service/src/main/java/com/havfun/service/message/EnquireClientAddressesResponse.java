package com.havfun.service.message;

import java.util.List;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.AddressMessage;

public class EnquireClientAddressesResponse extends AbstractResponse {
	
	private List<AddressMessage> addressMessageList;
	
	public EnquireClientAddressesResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_CLIENT_RESPONSE);
	}

	public List<AddressMessage> getAddressMessageList() {
		return addressMessageList;
	}

	public void setAddressMessageList(List<AddressMessage> addressMessageList) {
		this.addressMessageList = addressMessageList;
	}

	@Override
	public String toString() {
		return "EnquireClientAddressesResponse [addressMessageList=" + addressMessageList + ", result=" + result
				+ ", messageId=" + messageId + "]";
	}


}

