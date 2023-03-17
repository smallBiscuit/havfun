package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Order;
import com.havfun.service.message.data.OrderMessage;
import com.havfun.service.entity.constant.OrderStatus;

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
		order.setPaymentFirstName(orderMessage.getPaymentFirstName());
		order.setPaymentLastName(orderMessage.getPaymentLastName());
		order.setPaymentAddress1(orderMessage.getPaymentAddress1());
		order.setPaymentAddress2(orderMessage.getPaymentAddress2());
		order.setPaymentCity(orderMessage.getPaymentCity());
		order.setPaymentPostcode(orderMessage.getPaymentPostcode());
		order.setPaymentCountry(orderMessage.getPaymentCountry());
		order.setPaymentCountryId(orderMessage.getPaymentCountryId());
		order.setPaymentZone(orderMessage.getPaymentZone());
		order.setPaymentZoneId(orderMessage.getPaymentZoneId());
		order.setPaymentMethodId(orderMessage.getPaymentMethodId());
		order.setPaymentCode(orderMessage.getPaymentCode());
		order.setPaymentTelephone(orderMessage.getPaymentTelephone());
		order.setShippingFirstName(orderMessage.getShippingFirstName());
		order.setShippingLastName(orderMessage.getShippingLastName());
		order.setShippingAddress1(orderMessage.getShippingAddress1());
		order.setShippingAddress2(orderMessage.getShippingAddress2());
		order.setShippingCity(orderMessage.getShippingCity());
		order.setShippingPostcode(orderMessage.getShippingPostcode());
		order.setShippingCountry(orderMessage.getShippingCountry());
		order.setShippingCountryId(orderMessage.getShippingCountryId());
		order.setShippingZone(orderMessage.getShippingZone());
		order.setShippingZoneId(orderMessage.getShippingZoneId());
		order.setShippingMethodId(orderMessage.getShippingMethodId());
		order.setShippingCode(orderMessage.getShippingCode());
		order.setShippingTelephone(orderMessage.getShippingTelephone());
		order.setComment(orderMessage.getComment());
		order.setTotal(orderMessage.getTotal());
		order.setStatus(orderMessage.getStatus());
		order.setCurrencyId(orderMessage.getCurrencyId());
		order.setCurrencyCode(orderMessage.getCurrencyCode());
		order.setCurrencyValue(orderMessage.getCurrencyValue());
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
		orderMessage.setPaymentFirstName(order.getPaymentFirstName());
		orderMessage.setPaymentLastName(order.getPaymentLastName());
		orderMessage.setPaymentAddress1(order.getPaymentAddress1());
		orderMessage.setPaymentAddress2(order.getPaymentAddress2());
		orderMessage.setPaymentCity(order.getPaymentCity());
		orderMessage.setPaymentPostcode(order.getPaymentPostcode());
		orderMessage.setPaymentCountry(order.getPaymentCountry());
		orderMessage.setPaymentCountryId(order.getPaymentCountryId());
		orderMessage.setPaymentZone(order.getPaymentZone());
		orderMessage.setPaymentZoneId(order.getPaymentZoneId());
		orderMessage.setPaymentMethodId(order.getPaymentMethodId());
		orderMessage.setPaymentCode(order.getPaymentCode());
		orderMessage.setPaymentTelephone(order.getPaymentTelephone());
		orderMessage.setShippingFirstName(order.getShippingFirstName());
		orderMessage.setShippingLastName(order.getShippingLastName());
		orderMessage.setShippingAddress1(order.getShippingAddress1());
		orderMessage.setShippingAddress2(order.getShippingAddress2());
		orderMessage.setShippingCity(order.getShippingCity());
		orderMessage.setShippingPostcode(order.getShippingPostcode());
		orderMessage.setShippingCountry(order.getShippingCountry());
		orderMessage.setShippingCountryId(order.getShippingCountryId());
		orderMessage.setShippingZone(order.getShippingZone());
		orderMessage.setShippingZoneId(order.getShippingZoneId());
		orderMessage.setShippingMethodId(order.getShippingMethodId());
		orderMessage.setShippingCode(order.getShippingCode());
		orderMessage.setShippingTelephone(order.getShippingTelephone());
		orderMessage.setComment(order.getComment());
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


