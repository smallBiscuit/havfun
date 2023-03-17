package com.havfun.appsservice.message;

public class EnquireProductDetailsRequest extends AbstractRequest{

	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "EnquireProductDetailsRequest [productId=" + productId + ", clientId=" + clientId + ", token=" + token
				+ "]";
	}
	
	
	
}
