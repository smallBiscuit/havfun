package com.havfun.service.message;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class SearchOrderResponse extends AbstractResponse {
	
	private List<OrderMessage> orderMessageList;
	
	public SearchOrderResponse() {
		setMessageId(MessageId.SEARCH_ORDER_RESPONSE);
	}

	public List<OrderMessage> getOrderMessageList() {
		return orderMessageList;
	}

	public void setOrderMessageList(List<OrderMessage> orderMessageList) {
		this.orderMessageList = orderMessageList;
	}

	@Override
	public String toString() {
		return "SearchOrderResponse [orderMessageList=" + orderMessageList + ", result=" + result + ", messageId="
				+ messageId + "]";
	}

	

}
