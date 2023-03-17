package com.havfun.service.entity;

public class ProductAttributeOption {

	private int optionId;
	
	private int productAttributeId;

	private String productAttributeKey;

	private String productAttributeNameEn;
	
	private String productAttributeNameHk;
	
	private String productAttributeNameCn;
	
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

	public String getProductAttributeKey() {
		return productAttributeKey;
	}

	public void setProductAttributeKey(String productAttributeKey) {
		this.productAttributeKey = productAttributeKey;
	}

	public String getProductAttributeNameEn() {
		return productAttributeNameEn;
	}

	public void setProductAttributeNameEn(String productAttributeNameEn) {
		this.productAttributeNameEn = productAttributeNameEn;
	}

	public String getProductAttributeNameHk() {
		return productAttributeNameHk;
	}

	public void setProductAttributeNameHk(String productAttributeNameHk) {
		this.productAttributeNameHk = productAttributeNameHk;
	}

	public String getProductAttributeNameCn() {
		return productAttributeNameCn;
	}

	public void setProductAttributeNameCn(String productAttributeNameCn) {
		this.productAttributeNameCn = productAttributeNameCn;
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
				+ ", productAttributeKey=" + productAttributeKey + ", productAttributeNameEn=" + productAttributeNameEn
				+ ", productAttributeNameHk=" + productAttributeNameHk + ", productAttributeNameCn="
				+ productAttributeNameCn + ", value=" + value + ", name=" + name + "]";
	}


}
