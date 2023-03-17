package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class EnquireProductRequest extends AbstractRequest {
	
	private int productId;
	
	public EnquireProductRequest() {
		setMessageId(MessageId.ENQUIRE_PRODUCT_REQUEST);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "EnquireProductRequest [productId=" + productId + ", clientId=" + clientId + ", token=" + token
				+ ", messageId=" + messageId + "]";
	}
	
}
