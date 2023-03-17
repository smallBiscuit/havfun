package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class SearchProductGroupRequest extends AbstractRequest{

	public SearchProductGroupRequest() {
		setMessageId(MessageId.SEARCH_PRODUCT_GROUP_REQUEST);
	}

	@Override
	public String toString() {
		return "SearchProductGroupRequest [clientId=" + clientId + ", token=" + token + ", messageId=" + messageId
				+ "]";
	}
	
	
}
