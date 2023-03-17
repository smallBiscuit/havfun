package com.havfun.service.message.data;

import java.math.BigDecimal;

public class CourierMessage {

	private int courierId;
	
	private int forwarderId;
	
	private String forwarderNameEn;
	
	private String forwarderNameHk;
	
	private String forwarderNameCn;
	
	private String countryCode;
	
	private BigDecimal fromWeight;
	
	private BigDecimal toWeight;
	
	private BigDecimal baseWeight;
	
	private BigDecimal baseCost;
	
	private BigDecimal weightPerTier;
	
	private BigDecimal chargePerTier;
	
	private BigDecimal serviceChargePercentage;
	
	private BigDecimal fuelChargePercentage;

	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public int getForwarderId() {
		return forwarderId;
	}

	public void setForwarderId(int forwarderId) {
		this.forwarderId = forwarderId;
	}

	public String getForwarderNameEn() {
		return forwarderNameEn;
	}

	public void setForwarderNameEn(String forwarderNameEn) {
		this.forwarderNameEn = forwarderNameEn;
	}

	public String getForwarderNameHk() {
		return forwarderNameHk;
	}

	public void setForwarderNameHk(String forwarderNameHk) {
		this.forwarderNameHk = forwarderNameHk;
	}

	public String getForwarderNameCn() {
		return forwarderNameCn;
	}

	public void setForwarderNameCn(String forwarderNameCn) {
		this.forwarderNameCn = forwarderNameCn;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public BigDecimal getFromWeight() {
		return fromWeight;
	}

	public void setFromWeight(BigDecimal fromWeight) {
		this.fromWeight = fromWeight;
	}

	public BigDecimal getToWeight() {
		return toWeight;
	}

	public void setToWeight(BigDecimal toWeight) {
		this.toWeight = toWeight;
	}

	public BigDecimal getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(BigDecimal baseWeight) {
		this.baseWeight = baseWeight;
	}

	public BigDecimal getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(BigDecimal baseCost) {
		this.baseCost = baseCost;
	}

	public BigDecimal getWeightPerTier() {
		return weightPerTier;
	}

	public void setWeightPerTier(BigDecimal weightPerTier) {
		this.weightPerTier = weightPerTier;
	}

	public BigDecimal getChargePerTier() {
		return chargePerTier;
	}

	public void setChargePerTier(BigDecimal chargePerTier) {
		this.chargePerTier = chargePerTier;
	}

	public BigDecimal getServiceChargePercentage() {
		return serviceChargePercentage;
	}

	public void setServiceChargePercentage(BigDecimal serviceChargePercentage) {
		this.serviceChargePercentage = serviceChargePercentage;
	}

	public BigDecimal getFuelChargePercentage() {
		return fuelChargePercentage;
	}

	public void setFuelChargePercentage(BigDecimal fuelChargePercentage) {
		this.fuelChargePercentage = fuelChargePercentage;
	}

	@Override
	public String toString() {
		return "CourierMessage [courierId=" + courierId + ", forwarderId=" + forwarderId + ", forwarderNameEn="
				+ forwarderNameEn + ", forwarderNameHk=" + forwarderNameHk + ", forwarderNameCn=" + forwarderNameCn
				+ ", countryCode=" + countryCode + ", fromWeight=" + fromWeight + ", toWeight=" + toWeight
				+ ", baseWeight=" + baseWeight + ", baseCost=" + baseCost + ", weightPerTier=" + weightPerTier
				+ ", chargePerTier=" + chargePerTier + ", serviceChargePercentage=" + serviceChargePercentage
				+ ", fuelChargePercentage=" + fuelChargePercentage + "]";
	}


}
