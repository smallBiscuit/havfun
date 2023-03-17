package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductMessage;

public class EnquireProductResponse extends AbstractResponse {
	
	private ProductMessage productMessage;
	
	public EnquireProductResponse() {
		setMessageId(MessageId.ENQUIRE_PRODUCT_RESPONSE);
	}

	public ProductMessage getProductMessage() {
		return productMessage;
	}

	public void setProductMessage(ProductMessage productMessage) {
		this.productMessage = productMessage;
	}

	@Override
	public String toString() {
		return "EnquireProductResponse [productMessage=" + productMessage + ", result=" + result + ", messageId="
				+ messageId + "]";
	}



}
