package com.havfun.appsservice.data;

import java.math.BigDecimal;
import java.util.List;

public class Cart {

	private List<CartProduct> products;
	
	private BigDecimal discountTotalAmount;
	
	private BigDecimal totalAmount;
	
	private BigDecimal finalTotalAmount;

	public List<CartProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CartProduct> products) {
		this.products = products;
	}

	public BigDecimal getDiscountTotalAmount() {
		return discountTotalAmount;
	}

	public void setDiscountTotalAmount(BigDecimal discountTotalAmount) {
		this.discountTotalAmount = discountTotalAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getFinalTotalAmount() {
		return finalTotalAmount;
	}

	public void setFinalTotalAmount(BigDecimal finalTotalAmount) {
		this.finalTotalAmount = finalTotalAmount;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + ", discountTotalAmount=" + discountTotalAmount + ", totalAmount="
				+ totalAmount + ", finalTotalAmount=" + finalTotalAmount + "]";
	}

	
	
}
