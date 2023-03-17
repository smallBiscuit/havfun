package com.havfun.service.entity;

import java.math.BigDecimal;

public class ProductDiscount {
	
	private int productDiscountId;
	
	private int productId;
	
	private String clientGroup;
	
	private long quantity;
	
	private int priority;
	
	private BigDecimal price;
	
	int startDate;
	
	int endDate;

	public int getProductDiscountId() {
		return productDiscountId;
	}

	public void setProductDiscountId(int productDiscountId) {
		this.productDiscountId = productDiscountId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getClientGroup() {
		return clientGroup;
	}

	public void setClientGroup(String clientGroup) {
		this.clientGroup = clientGroup;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ProductDiscount [productDiscountId=" + productDiscountId + ", productId=" + productId + ", clientGroup="
				+ clientGroup + ", quantity=" + quantity + ", priority=" + priority + ", price=" + price
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
