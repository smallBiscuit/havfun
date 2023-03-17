package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class SearchProductRequest extends AbstractRequest{

	private int productGroupId;
	
	public SearchProductRequest() {
		setMessageId(MessageId.SEARCH_PRODUCT_REQUEST);
	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	@Override
	public String toString() {
		return "SearchProductRequest [productGroupId=" + productGroupId + ", clientId=" + clientId + ", token=" + token
				+ ", messageId=" + messageId + "]";
	}
	
	
}
