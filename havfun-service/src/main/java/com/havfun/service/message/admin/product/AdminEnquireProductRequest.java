package com.havfun.service.message.admin.product;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireProductRequest extends BaseAdminRequest {
	
	private int clientId;
	
	public AdminEnquireProductRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_PRODUCT_REQUEST);
	}

	public int getProductId() {
		return clientId;
	}

	public void setProductId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireProductRequest [clientId=");
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
