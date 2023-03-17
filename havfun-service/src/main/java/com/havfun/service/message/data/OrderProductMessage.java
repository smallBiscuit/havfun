package com.havfun.service.message.data;

import java.math.BigDecimal;

public class OrderProductMessage {

	private int orderProductId;
	
	private int orderId;
	
	private int productId;
	
	private String name;
	
	private String model;
	
	private int quantity;
	
	private BigDecimal price;
	
	private BigDecimal total;
	
	private BigDecimal tax;
	
	private int reward;

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "OrderProductMessage [orderProductId=" + orderProductId + ", orderId=" + orderId + ", productId="
				+ productId + ", name=" + name + ", model=" + model + ", quantity=" + quantity + ", price=" + price
				+ ", total=" + total + ", tax=" + tax + ", reward=" + reward + "]";
	}

	
}
