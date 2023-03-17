package com.havfun.service.message.admin.product;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchProductRequest extends BaseAdminRequest {
	
	private int productGroupId;
	
	private String productGroupTag;

	
	
	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupTag() {
		return productGroupTag;
	}

	public void setProductGroupTag(String productGroupTag) {
		this.productGroupTag = productGroupTag;
	}

	public AdminSearchProductRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_PRODUCT_REQUEST);
	}

	@Override
	public String toString() {
		return "AdminSearchProductRequest [productGroupId=" + productGroupId + ", productGroupTag=" + productGroupTag
				+ ", loginUserId=" + loginUserId + ", token=" + token + ", clientId=" + clientId + ", messageId="
				+ messageId + "]";
	}	

}
