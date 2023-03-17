package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.appsservice.data.ProductGroup;

public class SearchAllProductGroupsResponse extends AbstractResponse{

	private List<ProductGroup> productGroupList;

	public List<ProductGroup> getProductGroupList() {
		return productGroupList;
	}

	public void setProductGroupList(List<ProductGroup> productGroupList) {
		this.productGroupList = productGroupList;
	}

	@Override
	public String toString() {
		return "SearchAllProductGroupsResponse [productGroupList=" + productGroupList + ", result=" + result + ", reason="
				+ reason + "]";
	}
	
	
}