package com.havfun.service.entity;

import java.math.BigDecimal;

import com.havfun.service.entity.constant.CouponStatus;
import com.havfun.service.entity.constant.CouponType;

public class Coupon {

	private int couponId;
	
	private String name;
	
	private String code;
	
	private CouponType type;
	
	private BigDecimal discount;
	
	private boolean logged;
	
	private boolean shipping;
	
	private BigDecimal total;
	
	private int startDate;
	
	private int endDate;
	
	private int usesTotal;
	
	private int usesClient;
	
	private CouponStatus status;
	
	private long createTimestamp;

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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

	public int getUsesTotal() {
		return usesTotal;
	}

	public void setUsesTotal(int usesTotal) {
		this.usesTotal = usesTotal;
	}

	public int getUsesClient() {
		return usesClient;
	}

	public void setUsesClient(int usesClient) {
		this.usesClient = usesClient;
	}

	public CouponStatus getStatus() {
		return status;
	}

	public void setStatus(CouponStatus status) {
		this.status = status;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", name=" + name + ", code=" + code + ", type=" + type + ", discount="
				+ discount + ", logged=" + logged + ", shipping=" + shipping + ", total=" + total + ", startDate="
				+ startDate + ", endDate=" + endDate + ", usesTotal=" + usesTotal + ", usesClient=" + usesClient
				+ ", status=" + status + ", createTimestamp=" + createTimestamp + "]";
	}
	
	
}
