package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.OrderOption;
import com.havfun.service.message.data.OrderOptionMessage;

public class OrderOptionConvertor {

	public final static List<OrderOption> convertToEntityList(List<OrderOptionMessage> orderOptionMessageList) {
		if (orderOptionMessageList == null) {
			return null;
		}

		List<OrderOption> orderOptionList = new ArrayList<OrderOption>();
		for (OrderOptionMessage orderOptionMessage : orderOptionMessageList) {
			orderOptionList.add(convertToEntity(orderOptionMessage));
		}

		return orderOptionList;
	}

	public final static List<OrderOptionMessage> convertToMessageList(List<OrderOption> orderOptionList) {
		if (orderOptionList == null) {
			return null;
		}

		List<OrderOptionMessage> orderOptionMessageList = new ArrayList<OrderOptionMessage>();
		for (OrderOption orderOption : orderOptionList) {
			orderOptionMessageList.add(convertToMessage(orderOption));
		}

		return orderOptionMessageList;
	}

	public final static OrderOption convertToEntity(OrderOptionMessage orderOptionMessage) {
		OrderOption orderOption = new OrderOption();

		orderOption.setOrderOptionId(orderOptionMessage.getOrderOptionId());
		orderOption.setOrderId(orderOptionMessage.getOrderId());
		orderOption.setOrderProductId(orderOptionMessage.getOrderProductId());
		orderOption.setProductOptionId(orderOptionMessage.getProductOptionId());
		orderOption.setProductOptionValueId(orderOptionMessage.getProductOptionValueId());
		orderOption.setName(orderOptionMessage.getName());
		orderOption.setValue(orderOptionMessage.getValue());
		orderOption.setType(orderOptionMessage.getType());

		return orderOption;
	}

	public final static OrderOptionMessage convertToMessage(OrderOption orderOption) {
		OrderOptionMessage orderOptionMessage = new OrderOptionMessage();

		orderOptionMessage.setOrderOptionId(orderOption.getOrderOptionId());
		orderOptionMessage.setOrderId(orderOption.getOrderId());
		orderOptionMessage.setOrderProductId(orderOption.getOrderProductId());
		orderOptionMessage.setProductOptionId(orderOption.getProductOptionId());
		orderOptionMessage.setProductOptionValueId(orderOption.getProductOptionValueId());
		orderOptionMessage.setName(orderOption.getName());
		orderOptionMessage.setValue(orderOption.getValue());
		orderOptionMessage.setType(orderOption.getType());

		return orderOptionMessage;
	}

}


