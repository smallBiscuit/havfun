package com.havfun.service.message.data;

public class ProductAttributeMessage {

	private int productAttributeId;
	
	private int productId;
	
	private String attributeKey;
	
	private int sortOrder;

	public int getProductAttributeId() {
		return productAttributeId;
	}

	public void setProductAttributeId(int productAttributeId) {
		this.productAttributeId = productAttributeId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getAttributeKey() {
		return attributeKey;
	}

	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "ProductAttribute [productAttributeId=" + productAttributeId + ", productId=" + productId
				+ ", attributeKey=" + attributeKey + ", sortOrder=" + sortOrder + "]";
	}


	
}
