package com.havfun.appsservice.message;

import java.math.BigDecimal;
import java.util.List;

import com.havfun.appsservice.data.Address;
import com.havfun.appsservice.data.PaymentMethod;
import com.havfun.appsservice.data.ShippingMethod;

public class EnquireCheckoutInfoResponse extends AbstractResponse{

	private List<Address> addressList;

	private List<List<ShippingMethod>> shippingMethodsList;
	
	private List<PaymentMethod> paymentMethodList;
	
	private BigDecimal totalWeight;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<List<ShippingMethod>> getShippingMethodsList() {
		return shippingMethodsList;
	}

	public void setShippingMethodsList(List<List<ShippingMethod>> shippingMethodsList) {
		this.shippingMethodsList = shippingMethodsList;
	}

	public List<PaymentMethod> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<PaymentMethod> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}
	
	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	@Override
	public String toString() {
		return "EnquireCheckoutInfoResponse [addressList=" + addressList + ", shippingMethodsList="
				+ shippingMethodsList + ", paymentMethodList=" + paymentMethodList + ", totalWeight=" + totalWeight
				+ ", result=" + result + ", reason=" + reason + "]";
	}

	
}
