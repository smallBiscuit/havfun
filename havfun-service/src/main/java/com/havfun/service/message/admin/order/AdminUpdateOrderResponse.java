package com.havfun.service.message.admin.order;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateOrderResponse extends AbstractResponse {
	
	public AdminUpdateOrderResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_ORDER_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateOrderResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
