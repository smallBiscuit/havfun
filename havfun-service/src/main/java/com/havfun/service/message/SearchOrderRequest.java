package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class SearchOrderRequest extends AbstractRequest {
	
	public SearchOrderRequest() {
		setMessageId(MessageId.SEARCH_ORDER_REQUEST);
	}

	@Override
	public String toString() {
		return "SearchOrderRequest [clientId=" + clientId + ", token=" + token + ", messageId=" + messageId + "]";
	}

	
}
