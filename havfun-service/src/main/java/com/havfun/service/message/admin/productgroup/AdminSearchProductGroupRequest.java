package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchProductGroupRequest extends BaseAdminRequest {
	
	public AdminSearchProductGroupRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_PRODUCT_GROUP_REQUEST);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchProductGroupRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
