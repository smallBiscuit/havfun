package com.havfun.appsservice.data;

public class ProductAttributeOption {

	private int optionId;
	
	private int productAttributeId;

	private String value;	
	
	private String name;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getProductAttributeId() {
		return productAttributeId;
	}

	public void setProductAttributeId(int productAttributeId) {
		this.productAttributeId = productAttributeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductAttributeOption [optionId=" + optionId + ", productAttributeId=" + productAttributeId
				+ ", value=" + value + ", name=" + name + "]";
	}
}
