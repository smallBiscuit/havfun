package com.havfun.appsservice.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CartProduct {

	private String key;
	
	private int productId;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private BigDecimal price;
	
	private BigDecimal weight;
	
	private long quantity;
	
	private List<ProductAttribute> attributeList;
	
	private Map<String, String> optionMap;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameHk() {
		return nameHk;
	}

	public void setNameHk(String nameHk) {
		this.nameHk = nameHk;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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

	public List<ProductAttribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<ProductAttribute> attributeList) {
		this.attributeList = attributeList;
	}

	@Override
	public String toString() {
		return "CartProduct [key=" + key + ", productId=" + productId + ", nameEn=" + nameEn + ", nameHk=" + nameHk
				+ ", nameCn=" + nameCn + ", price=" + price + ", weight=" + weight + ", quantity=" + quantity
				+ ", attributeList=" + attributeList + ", optionMap=" + optionMap + "]";
	}

	

}
