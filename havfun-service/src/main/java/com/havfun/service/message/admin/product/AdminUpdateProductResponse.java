package com.havfun.service.message.admin.product;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateProductResponse extends AbstractResponse {
	
	public AdminUpdateProductResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_PRODUCT_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateProductResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
