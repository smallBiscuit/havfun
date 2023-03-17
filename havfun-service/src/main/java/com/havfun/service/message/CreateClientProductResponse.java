package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class CreateClientProductResponse extends AbstractResponse {
	
	private int clientProductId;
	
	public CreateClientProductResponse() {
		setMessageId(MessageId.CREATE_CLIENT_PRODUCT_RESPONSE);
	}

	public int getClientProductId() {
		return clientProductId;
	}

	public void setClientProductId(int clientProductId) {
		this.clientProductId = clientProductId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateClientProductResponse [clientProductId=");
		builder.append(clientProductId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

	


}

