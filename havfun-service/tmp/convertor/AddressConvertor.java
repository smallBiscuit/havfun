package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Address;
import com.havfun.service.message.data.AddressMessage;

public class AddressConvertor {

	public final static List<Address> convertToEntityList(List<AddressMessage> addressMessageList) {
		if (addressMessageList == null) {
			return null;
		}

		List<Address> addressList = new ArrayList<Address>();
		for (AddressMessage addressMessage : addressMessageList) {
			addressList.add(convertToEntity(addressMessage));
		}

		return addressList;
	}

	public final static List<AddressMessage> convertToMessageList(List<Address> addressList) {
		if (addressList == null) {
			return null;
		}

		List<AddressMessage> addressMessageList = new ArrayList<AddressMessage>();
		for (Address address : addressList) {
			addressMessageList.add(convertToMessage(address));
		}

		return addressMessageList;
	}

	public final static Address convertToEntity(AddressMessage addressMessage) {
		Address address = new Address();

		address.setAddressId(addressMessage.getAddressId());
		address.setClientId(addressMessage.getClientId());
		address.setFirstName(addressMessage.getFirstName());
		address.setLastName(addressMessage.getLastName());
		address.setAddress1(addressMessage.getAddress1());
		address.setAddress2(addressMessage.getAddress2());
		address.setCity(addressMessage.getCity());
		address.setPostcode(addressMessage.getPostcode());
		address.setCountryId(addressMessage.getCountryId());
		address.setZoneId(addressMessage.getZoneId());
		address.setTelephone(addressMessage.getTelephone());
		address.setBillingAddress(addressMessage.isBillingAddress());
		address.setShippingAddress(addressMessage.isShippingAddress());

		return address;
	}

	public final static AddressMessage convertToMessage(Address address) {
		AddressMessage addressMessage = new AddressMessage();

		addressMessage.setAddressId(address.getAddressId());
		addressMessage.setClientId(address.getClientId());
		addressMessage.setFirstName(address.getFirstName());
		addressMessage.setLastName(address.getLastName());
		addressMessage.setAddress1(address.getAddress1());
		addressMessage.setAddress2(address.getAddress2());
		addressMessage.setCity(address.getCity());
		addressMessage.setPostcode(address.getPostcode());
		addressMessage.setCountryId(address.getCountryId());
		addressMessage.setZoneId(address.getZoneId());
		addressMessage.setTelephone(address.getTelephone());
		addressMessage.setBillingAddress(address.isBillingAddress());
		addressMessage.setShippingAddress(address.isShippingAddress());

		return addressMessage;
	}

}


