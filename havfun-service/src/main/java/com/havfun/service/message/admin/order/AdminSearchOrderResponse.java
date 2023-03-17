package com.havfun.service.message.admin.order;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class AdminSearchOrderResponse extends AbstractResponse {
	
	private List<OrderMessage> orderMessageList;
	
	public AdminSearchOrderResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_ORDER_RESPONSE);
	}

	public List<OrderMessage> getOrderMessageList() {
		return orderMessageList;
	}

	public void setOrderMessageList(List<OrderMessage> orderMessageList) {
		this.orderMessageList = orderMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchOrderResponse [orderMessageList=");
		builder.append(orderMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
