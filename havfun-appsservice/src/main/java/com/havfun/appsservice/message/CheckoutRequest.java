package com.havfun.appsservice.message;

public class CheckoutRequest extends AbstractRequest{

	private String billingAddress;
	
	private String shippingAddress;

	private int paymentMethodId;
	
	private int shippingMethodId;

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
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

	@Override
	public String toString() {
		return "CheckoutRequest [billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
				+ ", paymentMethodId=" + paymentMethodId + ", shippingMethodId=" + shippingMethodId + ", clientId="
				+ clientId + ", token=" + token + "]";
	}
	
	
}
