package com.havfun.service.message.admin.productgroup;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductGroupMessage;

public class AdminSearchProductGroupResponse extends AbstractResponse {
	
	private List<ProductGroupMessage> productGroupMessageList;
	
	public AdminSearchProductGroupResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_PRODUCT_GROUP_RESPONSE);
	}

	public List<ProductGroupMessage> getProductGroupMessageList() {
		return productGroupMessageList;
	}

	public void setProductGroupMessageList(List<ProductGroupMessage> productGroupMessageList) {
		this.productGroupMessageList = productGroupMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchProductGroupResponse [productGroupMessageList=");
		builder.append(productGroupMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
