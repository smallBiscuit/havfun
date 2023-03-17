package com.havfun.appsservice.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.appsservice.data.Address;
import com.havfun.service.message.data.AddressMessage;

public class AddressConvertor {

	public final static List<Address> convertMessageToDataList(List<AddressMessage> addressMessageList) {
		if (addressMessageList == null) {
			return null;
		}

		List<Address> addressList = new ArrayList<Address>();
		for (AddressMessage addressMessage : addressMessageList) {
			addressList.add(convertorAddressMessageToAddress(addressMessage));
		}

		return addressList;
	}

	public final static List<AddressMessage> convertDataToMessageList(List<Address> addressList) {
		if (addressList == null) {
			return null;
		}

		List<AddressMessage> addressMessageList = new ArrayList<AddressMessage>();
		for (Address address : addressList) {
			addressMessageList.add(convertorAddressToAddressMessage(address));
		}

		return addressMessageList;
	}
	
	public static Address convertorAddressMessageToAddress( AddressMessage message ){
		
		Address address = new Address();
		
		address.setAddressId( message.getAddressId() );

		address.setFirstName( message.getFirstName() );
		
		address.setLastName( message.getLastName() );

		address.setAddress1( message.getAddress1() );
		
		address.setAddress2( message.getAddress2() );

		address.setCountryId( message.getCountryId() );

		address.setCountryCode( message.getCountryCode() );
		
		address.setCountryNameEn( message.getCountryNameEn() );

		address.setCountryNameHk( message.getCountryNameHk() );
		
		address.setCountryNameCn( message.getCountryNameCn() );
		
		address.setCity( message.getCity() );
		
		address.setPostcode( message.getPostcode() );
		
		address.setPhoneNumber( message.getTelephone() );
		
		address.setBillingAddress( message.isBillingAddress() );
		
		address.setShippingAddress( message.isShippingAddress() );
		
		return address;
		
	}
	
	public static AddressMessage convertorAddressToAddressMessage( Address address ){
	
		AddressMessage message = new AddressMessage();
		
		message.setAddressId( address.getAddressId() );

		message.setFirstName( address.getFirstName() );
		
		message.setLastName( address.getLastName() );

		message.setAddress1( address.getAddress1() );
		
		message.setAddress2( address.getAddress2() );

		message.setCountryId( address.getCountryId() );

		message.setCountryCode( address.getCountryCode() );

		message.setCountryNameEn( address.getCountryNameEn() );
		
		message.setCountryNameHk( address.getCountryNameHk() );
		
		message.setCountryNameCn( address.getCountryNameCn() );
		
		message.setCity( address.getCity() );
		
		message.setPostcode( address.getPostcode() );
		
		message.setTelephone( address.getPhoneNumber() );
		
		message.setBillingAddress( address.isBillingAddress() );
		
		message.setShippingAddress( address.isShippingAddress() );
		
		return message;
		
	}
	
}
