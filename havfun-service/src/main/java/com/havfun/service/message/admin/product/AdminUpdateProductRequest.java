package com.havfun.service.message.admin.product;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductMessage;

public class AdminUpdateProductRequest extends BaseAdminRequest{
	
	private ProductMessage clientMessage;
	
	public AdminUpdateProductRequest() {
		setMessageId(MessageId.ADMIN_UPDATE_PRODUCT_REQUEST);
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
		builder.append("AdminUpdateProductRequest [clientMessage=");
		builder.append(clientMessage);
		builder.append(", loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
