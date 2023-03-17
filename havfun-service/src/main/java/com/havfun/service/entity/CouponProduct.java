package com.havfun.service.entity;

public class CouponProduct {

	private int couponProductId;
	
	private int couponId;
	
	private int productId;

	public int getCouponProductId() {
		return couponProductId;
	}

	public void setCouponProductId(int couponProductId) {
		this.couponProductId = couponProductId;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "CouponProduct [couponProductId=" + couponProductId + ", couponId=" + couponId + ", productId="
				+ productId + "]";
	}
	
	
	
}
