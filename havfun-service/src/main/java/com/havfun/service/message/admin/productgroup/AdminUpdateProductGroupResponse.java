package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateProductGroupResponse extends AbstractResponse {
	
	public AdminUpdateProductGroupResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_PRODUCT_GROUP_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateProductGroupResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
