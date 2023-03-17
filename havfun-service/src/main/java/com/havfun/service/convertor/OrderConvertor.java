package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Order;
import com.havfun.service.message.data.OrderMessage;

public class OrderConvertor {

	public final static List<Order> convertToEntityList(List<OrderMessage> orderMessageList) {
		if (orderMessageList == null) {
			return null;
		}

		List<Order> orderList = new ArrayList<Order>();
		for (OrderMessage orderMessage : orderMessageList) {
			orderList.add(convertToEntity(orderMessage));
		}

		return orderList;
	}

	public final static List<OrderMessage> convertToMessageList(List<Order> orderList) {
		if (orderList == null) {
			return null;
		}

		List<OrderMessage> orderMessageList = new ArrayList<OrderMessage>();
		for (Order order : orderList) {
			orderMessageList.add(convertToMessage(order));
		}

		return orderMessageList;
	}

	public final static Order convertToEntity(OrderMessage orderMessage) {
		Order order = new Order();

		order.setOrderId(orderMessage.getOrderId());
		order.setInvoiceNo(orderMessage.getInvoiceNo());
		order.setStoreId(orderMessage.getStoreId());
		order.setStoreName(orderMessage.getStoreName());
		order.setStoreUrl(orderMessage.getStoreUrl());
		order.setClientId(orderMessage.getClientId());
		order.setClientGroup(orderMessage.getClientGroup());
		order.setFirstName(orderMessage.getFirstName());
		order.setLastName(orderMessage.getLastName());
		order.setEmail(orderMessage.getEmail());
		order.setTelephone(orderMessage.getTelephone());
		order.setFax(orderMessage.getFax());
		order.setBillingFirstName(orderMessage.getBillingFirstName());
		order.setBillingLastName(orderMessage.getBillingLastName());
		order.setBillingAddress1(orderMessage.getBillingAddress1());
		order.setBillingAddress2(orderMessage.getBillingAddress2());
		order.setBillingCity(orderMessage.getBillingCity());
		order.setBillingPostcode(orderMessage.getBillingPostcode());
		order.setBillingCountryId(orderMessage.getBillingCountryId());
		order.setBillingTelephone(orderMessage.getBillingTelephone());
		order.setShippingFirstName(orderMessage.getShippingFirstName());
		order.setShippingLastName(orderMessage.getShippingLastName());
		order.setShippingAddress1(orderMessage.getShippingAddress1());
		order.setShippingAddress2(orderMessage.getShippingAddress2());
		order.setShippingCity(orderMessage.getShippingCity());
		order.setShippingPostcode(orderMessage.getShippingPostcode());
		order.setShippingCountryId(orderMessage.getShippingCountryId());
		order.setShippingTelephone(orderMessage.getShippingTelephone());
		order.setShippingMethodId(orderMessage.getShippingMethodId());		
		order.setPaymentMethodId(orderMessage.getPaymentMethodId());
		order.setCurrencyId(orderMessage.getCurrencyId());
		order.setCurrencyCode(orderMessage.getCurrencyCode());
		order.setCurrencyValue(orderMessage.getCurrencyValue());
		order.setRemark(orderMessage.getRemark());
		order.setTotal(orderMessage.getTotal());
		order.setStatus(orderMessage.getStatus());
		order.setCreateTimestamp(orderMessage.getCreateTimestamp());
		order.setLastModifiedTimestamp(orderMessage.getLastModifiedTimestamp());

		return order;
	}

	public final static OrderMessage convertToMessage(Order order) {
		OrderMessage orderMessage = new OrderMessage();

		orderMessage.setOrderId(order.getOrderId());
		orderMessage.setInvoiceNo(order.getInvoiceNo());
		orderMessage.setStoreId(order.getStoreId());
		orderMessage.setStoreName(order.getStoreName());
		orderMessage.setStoreUrl(order.getStoreUrl());
		orderMessage.setClientId(order.getClientId());
		orderMessage.setClientGroup(order.getClientGroup());
		orderMessage.setFirstName(order.getFirstName());
		orderMessage.setLastName(order.getLastName());
		orderMessage.setEmail(order.getEmail());
		orderMessage.setTelephone(order.getTelephone());
		orderMessage.setFax(order.getFax());
		orderMessage.setBillingFirstName(order.getBillingFirstName());
		orderMessage.setBillingLastName(order.getBillingLastName());
		orderMessage.setBillingAddress1(order.getBillingAddress1());
		orderMessage.setBillingAddress2(order.getBillingAddress2());
		orderMessage.setBillingCity(order.getBillingCity());
		orderMessage.setBillingPostcode(order.getBillingPostcode());
		orderMessage.setBillingCountryId(order.getBillingCountryId());
		orderMessage.setBillingTelephone(order.getBillingTelephone());
		orderMessage.setShippingFirstName(order.getShippingFirstName());
		orderMessage.setShippingLastName(order.getShippingLastName());
		orderMessage.setShippingAddress1(order.getShippingAddress1());
		orderMessage.setShippingAddress2(order.getShippingAddress2());
		orderMessage.setShippingCity(order.getShippingCity());
		orderMessage.setShippingPostcode(order.getShippingPostcode());
		orderMessage.setShippingCountryId(order.getShippingCountryId());
		orderMessage.setShippingTelephone(order.getShippingTelephone());
		orderMessage.setPaymentMethodId(order.getPaymentMethodId());
		orderMessage.setShippingMethodId(order.getShippingMethodId());		
		orderMessage.setRemark(order.getRemark());
		orderMessage.setTotal(order.getTotal());
		orderMessage.setStatus(order.getStatus());
		orderMessage.setCurrencyId(order.getCurrencyId());
		orderMessage.setCurrencyCode(order.getCurrencyCode());
		orderMessage.setCurrencyValue(order.getCurrencyValue());
		orderMessage.setCreateTimestamp(order.getCreateTimestamp());
		orderMessage.setLastModifiedTimestamp(order.getLastModifiedTimestamp());

		return orderMessage;
	}

}


