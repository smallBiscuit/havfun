package com.havfun.service.message.admin.product;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductMessage;

public class AdminSearchProductResponse extends AbstractResponse {
	
	private List<ProductMessage> productMessageList;
	
	public AdminSearchProductResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_PRODUCT_RESPONSE);
	}

	public List<ProductMessage> getProductMessageList() {
		return productMessageList;
	}

	public void setProductMessageList(List<ProductMessage> productMessageList) {
		this.productMessageList = productMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchProductResponse [productMessageList=");
		builder.append(productMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
