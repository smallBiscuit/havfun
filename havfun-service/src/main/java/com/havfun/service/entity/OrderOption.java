package com.havfun.service.entity;

public class OrderOption {

	private int orderOptionId;
	
	private int orderId;

	private int orderProductId;
	
	private int productOptionId;
	
	private int productOptionValueId;
	
	private String name;
	
	private String value;
	
	private String type;

	public int getOrderOptionId() {
		return orderOptionId;
	}

	public void setOrderOptionId(int orderOptionId) {
		this.orderOptionId = orderOptionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public int getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(int productOptionId) {
		this.productOptionId = productOptionId;
	}

	public int getProductOptionValueId() {
		return productOptionValueId;
	}

	public void setProductOptionValueId(int productOptionValueId) {
		this.productOptionValueId = productOptionValueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "OrderOption [orderOptionId=" + orderOptionId + ", orderId=" + orderId + ", orderProductId="
				+ orderProductId + ", productOptionId=" + productOptionId + ", productOptionValueId="
				+ productOptionValueId + ", name=" + name + ", value=" + value + ", type=" + type + "]";
	}
	
	
	
}
