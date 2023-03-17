package com.havfun.service.entity;

import java.math.BigDecimal;

public class CouponHistory {

	private int couponHistoryId;
	
	private int couponId;
	
	private int orderId;
	
	private int clientId;
	
	private BigDecimal amount;
	
	private long createTimestamp;

	public int getCouponHistoryId() {
		return couponHistoryId;
	}

	public void setCouponHistoryId(int couponHistoryId) {
		this.couponHistoryId = couponHistoryId;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CouponHistory [couponHistoryId=" + couponHistoryId + ", couponId=" + couponId + ", orderId=" + orderId
				+ ", clientId=" + clientId + ", amount=" + amount + ", createTimestamp=" + createTimestamp + "]";
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
	
}
