package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductGroupMessage;

public class AdminUpdateProductGroupRequest extends BaseAdminRequest{
	
	private ProductGroupMessage clientMessage;
	
	public AdminUpdateProductGroupRequest() {
		setMessageId(MessageId.ADMIN_UPDATE_PRODUCT_GROUP_REQUEST);
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
		builder.append("AdminUpdateProductGroupRequest [clientMessage=");
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
