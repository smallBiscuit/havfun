package com.havfun.service.message.admin.product;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateProductResponse extends AbstractResponse {
	
	private int clientId;
	
	public AdminCreateProductResponse() {
		setMessageId(MessageId.ADMIN_CREATE_PRODUCT_RESPONSE);
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
		builder.append("AdminCreateProductResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
