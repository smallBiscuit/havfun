package com.havfun.service.message;

import java.util.List;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductGroupMessage;

public class SearchProductGroupResponse extends AbstractResponse{

	private List<ProductGroupMessage> productGroupMessageList;

	public SearchProductGroupResponse() {
		setMessageId(MessageId.SEARCH_PRODUCT_GROUP_RESPONSE);
	}

	public List<ProductGroupMessage> getProductGroupMessageList() {
		return productGroupMessageList;
	}

	public void setProductGroupMessageList(List<ProductGroupMessage> productGroupMessageList) {
		this.productGroupMessageList = productGroupMessageList;
	}

	@Override
	public String toString() {
		return "SearchProductGroupResponse [productGroupMessageList=" + productGroupMessageList + ", result=" + result
				+ ", messageId=" + messageId + "]";
	}
	

	
}
