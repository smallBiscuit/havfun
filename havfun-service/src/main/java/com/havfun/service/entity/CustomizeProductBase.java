package com.havfun.service.entity;

public class CustomizeProductBase {

	private int baseId;
	
	private int productId;
	
	public int getBaseId() {
		return baseId;
	}

	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "CustomizeProductBase [baseId=" + baseId + ", productId=" + productId + "]";
	}
	
	
}
