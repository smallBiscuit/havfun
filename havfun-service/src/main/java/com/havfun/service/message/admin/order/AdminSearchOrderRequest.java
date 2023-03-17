package com.havfun.service.message.admin.order;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchOrderRequest extends BaseAdminRequest {
	
	public AdminSearchOrderRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_ORDER_REQUEST);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchOrderRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
