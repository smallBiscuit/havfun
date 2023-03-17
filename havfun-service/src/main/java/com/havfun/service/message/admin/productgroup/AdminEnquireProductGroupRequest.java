package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireProductGroupRequest extends BaseAdminRequest {
	
	private int clientId;
	
	public AdminEnquireProductGroupRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_PRODUCT_GROUP_REQUEST);
	}

	public int getProductGroupId() {
		return clientId;
	}

	public void setProductGroupId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireProductGroupRequest [clientId=");
		builder.append(clientId);
		builder.append(", loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
