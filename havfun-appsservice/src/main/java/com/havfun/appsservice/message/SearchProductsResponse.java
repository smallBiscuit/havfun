package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.appsservice.data.Product;

public class SearchProductsResponse extends AbstractResponse{

	private List<Product> productList;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "SearchProductsResponse [productList=" + productList + ", result=" + result + ", reason=" + reason + "]";
	}



}
