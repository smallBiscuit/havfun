package com.havfun.service.message;

import java.util.List;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductMessage;

public class SearchProductResponse extends AbstractResponse{

	private List<ProductMessage> productMessageList;

	public SearchProductResponse() {
		setMessageId(MessageId.SEARCH_PRODUCT_RESPONSE);
	}

	public List<ProductMessage> getProductMessageList() {
		return productMessageList;
	}

	public void setProductMessageList(List<ProductMessage> productMessageList) {
		this.productMessageList = productMessageList;
	}

	@Override
	public String toString() {
		return "SearchProductResponse [productMessageList=" + productMessageList + ", result=" + result + ", messageId="
				+ messageId + "]";
	}


	

}
