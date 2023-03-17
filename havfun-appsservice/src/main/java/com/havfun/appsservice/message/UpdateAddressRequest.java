package com.havfun.appsservice.message;

import com.havfun.appsservice.data.Address;

public class UpdateAddressRequest extends AbstractRequest{

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UpdateAddressRequest [clientId=" + clientId + ", token=" + token + "]";
	}
	
	
}
