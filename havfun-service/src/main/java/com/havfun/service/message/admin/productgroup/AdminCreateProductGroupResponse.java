package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateProductGroupResponse extends AbstractResponse {
	
	private int clientId;
	
	public AdminCreateProductGroupResponse() {
		setMessageId(MessageId.ADMIN_CREATE_PRODUCT_GROUP_RESPONSE);
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
		builder.append("AdminCreateProductGroupResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
