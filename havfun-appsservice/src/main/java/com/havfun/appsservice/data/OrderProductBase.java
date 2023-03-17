package com.havfun.appsservice.data;

import java.math.BigDecimal;
import java.util.Map;

public class OrderProductBase {

	private int productId;
	
	private int quantity;
	
	private BigDecimal price;
	
	private Map<String, String> optionMap;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Map<String, String> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<String, String> optionMap) {
		this.optionMap = optionMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderProductBase [productId=");
		builder.append(productId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", optionMap=");
		builder.append(optionMap);
		builder.append("]");
		return builder.toString();
	}


}
