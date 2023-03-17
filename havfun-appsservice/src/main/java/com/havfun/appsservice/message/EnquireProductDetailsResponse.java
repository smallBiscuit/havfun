package com.havfun.appsservice.message;

import com.havfun.appsservice.data.Product;

public class EnquireProductDetailsResponse extends AbstractResponse{

	private Product productDetails;

	public Product getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(Product productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "EnquireProductDetailsResponse [productDetails=" + productDetails + ", result=" + result + ", reason="
				+ reason + "]";
	}
	
	
}
