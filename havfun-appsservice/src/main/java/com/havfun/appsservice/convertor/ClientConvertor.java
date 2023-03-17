package com.havfun.appsservice.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.appsservice.data.Address;
import com.havfun.appsservice.data.Client;
import com.havfun.appsservice.helper.DataHelper;
import com.havfun.service.message.data.AddressMessage;
import com.havfun.service.message.data.ClientMessage;

public class ClientConvertor {

	public static Client convertorClientMessageToClient( ClientMessage message, DataHelper dataHelper ){
		
		Client client = new Client();
		
		client.setClientGroup( message.getClientGroup() );
		
		client.setClientId( message.getClientId() );
		
		client.setFirstName( message.getFirstName() );
		
		client.setLastName( message.getLastName() );
		
		client.setBirthDate( message.getBirthDate() );
		
		client.setGender( message.getGender() );

		client.setEmail( message.getEmail() );
		
		client.setTelephone( message.getTelephone() );

		client.setFax( message.getFax() );

		List<Address> addressList = new ArrayList<Address>();
		
		if ( message.getAddressList() != null ){
		
			for ( AddressMessage addressMessage : message.getAddressList() ){
				
				Address address = new Address();
				
				address.setAddressId( addressMessage.getAddressId() );
				
				address.setFirstName( addressMessage.getFirstName() );
				
				address.setLastName( addressMessage.getLastName() );
				
				address.setAddress1( addressMessage.getAddress1() );
				
				address.setAddress2( addressMessage.getAddress2() );
				
				address.setCountryId( addressMessage.getCountryId() );
				
				address.setCountryCode( addressMessage.getCountryCode() );
				
				address.setCountryNameEn( addressMessage.getCountryNameEn() );
				
				address.setCountryNameHk( addressMessage.getCountryNameHk() );
				
				address.setCountryNameCn( addressMessage.getCountryNameCn() );				
				
				address.setCity( addressMessage.getCity() );
				
				address.setPostcode( addressMessage.getPostcode() );
				
				address.setPhoneNumber( addressMessage.getTelephone() );
				
				address.setBillingAddress( addressMessage.isBillingAddress() );
				
				address.setShippingAddress( addressMessage.isShippingAddress() );
				
				addressList.add(address);
				
			}
			
		}
		
		client.setAddressList(addressList);

		return client;

			
	}
}
