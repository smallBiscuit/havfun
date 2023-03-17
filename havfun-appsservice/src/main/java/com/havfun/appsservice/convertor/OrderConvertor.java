package com.havfun.appsservice.convertor;

import com.havfun.appsservice.data.Order;
import com.havfun.service.message.data.OrderMessage;

public class OrderConvertor {

	public static Order convertOrderMessageToOrder( OrderMessage message ){
		
		Order order = new Order();
		
		order.setOrderId( message.getOrderId() );
		order.setInvoiceNo( message.getInvoiceNo() );
		order.setStoreId( message.getStoreId() );
		order.setStoreName( message.getStoreName() );
		order.setStoreUrl( message.getStoreUrl() );
		order.setClientId( message.getClientId() );
		order.setClientGroup( message.getClientGroup() );
		order.setFirstName( message.getFirstName() );
		order.setLastName( message.getLastName() );
		order.setEmail( message.getEmail() );
		order.setTelephone( message.getEmail() );
		order.setFax( message.getFax() );
		
		order.setBillingFirstName( message.getBillingFirstName() );
		order.setBillingLastName( message.getBillingLastName() );
		order.setBillingAddress1( message.getBillingAddress1() );
		order.setBillingAddress2( message.getBillingAddress2() );
		order.setBillingCity( message.getBillingCity() );
		order.setBillingPostcode( message.getBillingPostcode() );
		order.setBillingCountryId( message.getBillingCountryId() );
		order.setBillingTelephone( message.getBillingTelephone() );
		
		order.setShippingFirstName( message.getShippingFirstName() );
		order.setShippingLastName( message.getShippingLastName() );
		order.setShippingAddress1( message.getShippingAddress1() );
		order.setShippingAddress2( message.getShippingAddress2() );
		order.setShippingCity( message.getShippingCity() );
		order.setShippingPostcode( message.getShippingPostcode() );
		order.setShippingCountryId( message.getShippingCountryId() );
		order.setShippingTelephone( message.getShippingTelephone() );
		
		order.setPaymentMethodId( message.getPaymentMethodId() );
		order.setShippingMethodId( message.getShippingMethodId() );
		order.setCurrencyId( message.getCurrencyId() );
		order.setCurrencyCode( message.getCurrencyCode() );
		order.setCurrencyValue( message.getCurrencyValue() );
		order.setRemark( message.getRemark() );
		order.setTotal( message.getTotal() );
		order.setStatus( message.getStatus() );
		order.setCreateTimestamp( message.getCreateTimestamp() );
		order.setLastModifiedTimestamp( message.getLastModifiedTimestamp() );
		
		return order;
	}
	
	
}
