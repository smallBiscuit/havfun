package com.havfun.service.message.data;

import java.math.BigDecimal;
import java.util.List;

public class OrderBaseMessage {
	
	private List<OrderProductMessage> orderProductList;
	
	private String billingFirstName;
	
	private String billingLastName;
	
	private String billingAddress1;
	
	private String billingAddress2;
	
	private String billingCity;
	
	private String billingPostcode;
	
	private int billingCountryId;
	
	private String billingTelephone;
	
	private String shippingFirstName;
	
	private String shippingLastName;
	
	private String shippingAddress1;
	
	private String shippingAddress2;
	
	private String shippingCity;
	
	private String shippingPostcode;
	
	private int shippingCountryId;
	
	private String shippingTelephone;
	
	private int paymentMethodId;
	
	private int shippingMethodId;
	
	private BigDecimal total;

	public List<OrderProductMessage> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProductMessage> orderProductList) {
		this.orderProductList = orderProductList;
	}

	public String getBillingFirstName() {
		return billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
	}

	public String getBillingLastName() {
		return billingLastName;
	}

	public void setBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingPostcode() {
		return billingPostcode;
	}

	public void setBillingPostcode(String billingPostcode) {
		this.billingPostcode = billingPostcode;
	}

	public int getBillingCountryId() {
		return billingCountryId;
	}

	public void setBillingCountryId(int billingCountryId) {
		this.billingCountryId = billingCountryId;
	}

	public String getBillingTelephone() {
		return billingTelephone;
	}

	public void setBillingTelephone(String billingTelephone) {
		this.billingTelephone = billingTelephone;
	}

	public String getShippingFirstName() {
		return shippingFirstName;
	}

	public void setShippingFirstName(String shippingFirstName) {
		this.shippingFirstName = shippingFirstName;
	}

	public String getShippingLastName() {
		return shippingLastName;
	}

	public void setShippingLastName(String shippingLastName) {
		this.shippingLastName = shippingLastName;
	}

	public String getShippingAddress1() {
		return shippingAddress1;
	}

	public void setShippingAddress1(String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
	}

	public String getShippingAddress2() {
		return shippingAddress2;
	}

	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingPostcode() {
		return shippingPostcode;
	}

	public void setShippingPostcode(String shippingPostcode) {
		this.shippingPostcode = shippingPostcode;
	}

	public int getShippingCountryId() {
		return shippingCountryId;
	}

	public void setShippingCountryId(int shippingCountryId) {
		this.shippingCountryId = shippingCountryId;
	}

	public String getShippingTelephone() {
		return shippingTelephone;
	}

	public void setShippingTelephone(String shippingTelephone) {
		this.shippingTelephone = shippingTelephone;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public int getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(int shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderBaseMessage [orderProductList=");
		builder.append(orderProductList);
		builder.append(", billingFirstName=");
		builder.append(billingFirstName);
		builder.append(", billingLastName=");
		builder.append(billingLastName);
		builder.append(", billingAddress1=");
		builder.append(billingAddress1);
		builder.append(", billingAddress2=");
		builder.append(billingAddress2);
		builder.append(", billingCity=");
		builder.append(billingCity);
		builder.append(", billingPostcode=");
		builder.append(billingPostcode);
		builder.append(", billingCountryId=");
		builder.append(billingCountryId);
		builder.append(", billingTelephone=");
		builder.append(billingTelephone);
		builder.append(", shippingFirstName=");
		builder.append(shippingFirstName);
		builder.append(", shippingLastName=");
		builder.append(shippingLastName);
		builder.append(", shippingAddress1=");
		builder.append(shippingAddress1);
		builder.append(", shippingAddress2=");
		builder.append(shippingAddress2);
		builder.append(", shippingCity=");
		builder.append(shippingCity);
		builder.append(", shippingPostcode=");
		builder.append(shippingPostcode);
		builder.append(", shippingCountryId=");
		builder.append(shippingCountryId);
		builder.append(", shippingTelephone=");
		builder.append(shippingTelephone);
		builder.append(", paymentMethodId=");
		builder.append(paymentMethodId);
		builder.append(", shippingMethodId=");
		builder.append(shippingMethodId);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

}
