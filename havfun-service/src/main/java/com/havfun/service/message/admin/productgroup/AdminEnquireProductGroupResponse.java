package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductGroupMessage;

public class AdminEnquireProductGroupResponse extends AbstractResponse {
	
	private ProductGroupMessage clientMessage;
	
	public AdminEnquireProductGroupResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_PRODUCT_GROUP_RESPONSE);
	}

	public ProductGroupMessage getProductGroupMessage() {
		return clientMessage;
	}

	public void setProductGroupMessage(ProductGroupMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireProductGroupResponse [clientMessage=");
		builder.append(clientMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
