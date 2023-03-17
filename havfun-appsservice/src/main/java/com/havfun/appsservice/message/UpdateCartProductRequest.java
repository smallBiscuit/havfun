package com.havfun.appsservice.message;

import java.util.Map;

public class UpdateCartProductRequest extends AbstractRequest{

	private int index;
	
	private int productId;
	
	private long quantity;
	
	private Map<String, String> optionMap;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Map<String, String> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<String, String> optionMap) {
		this.optionMap = optionMap;
	}

	@Override
	public String toString() {
		return "UpdateCartProductRequest [index=" + index + ", productId=" + productId + ", quantity=" + quantity
				+ ", optionMap=" + optionMap + ", clientId=" + clientId + ", token=" + token + "]";
	}

	
	
}
