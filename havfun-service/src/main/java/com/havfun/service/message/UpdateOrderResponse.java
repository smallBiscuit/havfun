package com.havfun.service.message;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class UpdateOrderResponse extends AbstractResponse {
	
	public UpdateOrderResponse() {
		setMessageId(MessageId.UPDATE_ORDER_RESPONSE);
	}

	@Override
	public String toString() {
		return "UpdateOrderResponse [result=" + result + ", messageId=" + messageId + "]";
	}
	
}
