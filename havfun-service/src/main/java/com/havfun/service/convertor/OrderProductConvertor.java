package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.OrderProduct;
import com.havfun.service.message.data.OrderProductMessage;

public class OrderProductConvertor {

	public final static List<OrderProduct> convertToEntityList(List<OrderProductMessage> orderProductMessageList) {
		if (orderProductMessageList == null) {
			return null;
		}

		List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
		for (OrderProductMessage orderProductMessage : orderProductMessageList) {
			orderProductList.add(convertToEntity(orderProductMessage));
		}

		return orderProductList;
	}

	public final static List<OrderProductMessage> convertToMessageList(List<OrderProduct> orderProductList) {
		if (orderProductList == null) {
			return null;
		}

		List<OrderProductMessage> orderProductMessageList = new ArrayList<OrderProductMessage>();
		for (OrderProduct orderProduct : orderProductList) {
			orderProductMessageList.add(convertToMessage(orderProduct));
		}

		return orderProductMessageList;
	}

	public final static OrderProduct convertToEntity(OrderProductMessage orderProductMessage) {
		OrderProduct orderProduct = new OrderProduct();

		orderProduct.setOrderProductId(orderProductMessage.getOrderProductId());
		orderProduct.setOrderId(orderProductMessage.getOrderId());
		orderProduct.setProductId(orderProductMessage.getProductId());
		orderProduct.setName(orderProductMessage.getName());
		orderProduct.setModel(orderProductMessage.getModel());
		orderProduct.setQuantity(orderProductMessage.getQuantity());
		orderProduct.setPrice(orderProductMessage.getPrice());
		orderProduct.setTotal(orderProductMessage.getTotal());
		orderProduct.setTax(orderProductMessage.getTax());
		orderProduct.setReward(orderProductMessage.getReward());

		return orderProduct;
	}

	public final static OrderProductMessage convertToMessage(OrderProduct orderProduct) {
		OrderProductMessage orderProductMessage = new OrderProductMessage();

		orderProductMessage.setOrderProductId(orderProduct.getOrderProductId());
		orderProductMessage.setOrderId(orderProduct.getOrderId());
		orderProductMessage.setProductId(orderProduct.getProductId());
		orderProductMessage.setName(orderProduct.getName());
		orderProductMessage.setModel(orderProduct.getModel());
		orderProductMessage.setQuantity(orderProduct.getQuantity());
		orderProductMessage.setPrice(orderProduct.getPrice());
		orderProductMessage.setTotal(orderProduct.getTotal());
		orderProductMessage.setTax(orderProduct.getTax());
		orderProductMessage.setReward(orderProduct.getReward());

		return orderProductMessage;
	}

}


