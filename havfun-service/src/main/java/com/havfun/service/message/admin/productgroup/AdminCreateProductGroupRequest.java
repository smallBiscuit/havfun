package com.havfun.service.message.admin.productgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductGroupMessage;

public class AdminCreateProductGroupRequest extends BaseAdminRequest{
	
	private ProductGroupMessage productGroupMessage;
	
	public AdminCreateProductGroupRequest() {
		setMessageId(MessageId.ADMIN_CREATE_PRODUCT_GROUP_REQUEST);
	}

	public ProductGroupMessage getProductGroupMessage() {
		return productGroupMessage;
	}

	public void setProductGroupMessage(ProductGroupMessage productGroupMessage) {
		this.productGroupMessage = productGroupMessage;
	}

	@Override
	public String toString() {
		return "AdminCreateProductGroupRequest [productGroupMessage=" + productGroupMessage + ", loginUserId="
				+ loginUserId + ", token=" + token + ", clientId=" + clientId + ", messageId=" + messageId + "]";
	}


}
