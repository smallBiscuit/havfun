package com.havfun.service.message.admin.product;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductMessage;

public class AdminEnquireProductResponse extends AbstractResponse {
	
	private ProductMessage clientMessage;
	
	public AdminEnquireProductResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_PRODUCT_RESPONSE);
	}

	public ProductMessage getProductMessage() {
		return clientMessage;
	}

	public void setProductMessage(ProductMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireProductResponse [clientMessage=");
		builder.append(clientMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
