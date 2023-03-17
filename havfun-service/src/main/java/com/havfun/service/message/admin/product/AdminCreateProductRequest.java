package com.havfun.service.message.admin.product;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ProductMessage;

public class AdminCreateProductRequest extends BaseAdminRequest{
	
	private ProductMessage productMessage;
	
	public AdminCreateProductRequest() {
		setMessageId(MessageId.ADMIN_CREATE_PRODUCT_REQUEST);
	}

	public ProductMessage getProductMessage() {
		return productMessage;
	}

	public void setProductMessage(ProductMessage productMessage) {
		this.productMessage = productMessage;
	}

	@Override
	public String toString() {
		return "AdminCreateProductRequest [productMessage=" + productMessage + ", loginUserId=" + loginUserId + ", token="
				+ token + ", clientId=" + clientId + ", messageId=" + messageId + "]";
	}

	


}
