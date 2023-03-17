package com.havfun.appsservice.data;

import java.math.BigDecimal;

public class ShippingMethod {

	private int methodId;
	private String displayName;
	private String type;
	private BigDecimal fee;
	private BigDecimal extraFee;
	public int getMethodId() {
		return methodId;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public BigDecimal getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(BigDecimal extraFee) {
		this.extraFee = extraFee;
	}
	
	@Override
	public String toString() {
		return "ShippingMethod [methodId=" + methodId + ", displayName=" + displayName + ", type=" + type + ", fee="
				+ fee + ", extraFee=" + extraFee + "]";
	}
	
}
