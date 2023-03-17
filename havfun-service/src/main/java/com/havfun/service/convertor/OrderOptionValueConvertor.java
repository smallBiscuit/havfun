package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.OrderOptionValue;
import com.havfun.service.message.data.OrderOptionValueMessage;

public class OrderOptionValueConvertor {

	public final static List<OrderOptionValue> convertToEntityList(List<OrderOptionValueMessage> orderOptionValueMessageList) {
		if (orderOptionValueMessageList == null) {
			return null;
		}

		List<OrderOptionValue> orderOptionValueList = new ArrayList<OrderOptionValue>();
		for (OrderOptionValueMessage orderOptionValueMessage : orderOptionValueMessageList) {
			orderOptionValueList.add(convertToEntity(orderOptionValueMessage));
		}

		return orderOptionValueList;
	}

	public final static List<OrderOptionValueMessage> convertToMessageList(List<OrderOptionValue> orderOptionValueList) {
		if (orderOptionValueList == null) {
			return null;
		}

		List<OrderOptionValueMessage> orderOptionValueMessageList = new ArrayList<OrderOptionValueMessage>();
		for (OrderOptionValue orderOptionValue : orderOptionValueList) {
			orderOptionValueMessageList.add(convertToMessage(orderOptionValue));
		}

		return orderOptionValueMessageList;
	}

	public final static OrderOptionValue convertToEntity(OrderOptionValueMessage orderOptionValueMessage) {
		OrderOptionValue orderOptionValue = new OrderOptionValue();

		orderOptionValue.setOrderOptionValueId(orderOptionValueMessage.getOrderOptionValueId());
		orderOptionValue.setOrderOptionId(orderOptionValueMessage.getOrderOptionId());
		orderOptionValue.setSortingOrder(orderOptionValueMessage.getSortingOrder());

		return orderOptionValue;
	}

	public final static OrderOptionValueMessage convertToMessage(OrderOptionValue orderOptionValue) {
		OrderOptionValueMessage orderOptionValueMessage = new OrderOptionValueMessage();

		orderOptionValueMessage.setOrderOptionValueId(orderOptionValue.getOrderOptionValueId());
		orderOptionValueMessage.setOrderOptionId(orderOptionValue.getOrderOptionId());
		orderOptionValueMessage.setSortingOrder(orderOptionValue.getSortingOrder());

		return orderOptionValueMessage;
	}

}


