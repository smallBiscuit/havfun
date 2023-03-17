package com.havfun.appsservice.message;

import java.math.BigDecimal;
import java.util.List;

import com.havfun.appsservice.data.OrderProductBase;

public class CreateOrderRequest extends AbstractRequest{

	private List<OrderProductBase> orderProductList;
	
	private int paymentAddressIndex;
	
	private int billingAddressIndex;
	
	private int paymentMethodId;
	
	private int shippingMethodId;

	private BigDecimal weight;
	
	private BigDecimal total;

	public List<OrderProductBase> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProductBase> orderProductList) {
		this.orderProductList = orderProductList;
	}

	public int getPaymentAddressIndex() {
		return paymentAddressIndex;
	}

	public void setPaymentAddressIndex(int paymentAddressIndex) {
		this.paymentAddressIndex = paymentAddressIndex;
	}

	public int getBillingAddressIndex() {
		return billingAddressIndex;
	}

	public void setBillingAddressIndex(int billingAddressIndex) {
		this.billingAddressIndex = billingAddressIndex;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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
		builder.append("CreateOrderRequest [orderProductList=");
		builder.append(orderProductList);
		builder.append(", paymentAddressIndex=");
		builder.append(paymentAddressIndex);
		builder.append(", billingAddressIndex=");
		builder.append(billingAddressIndex);
		builder.append(", paymentMethodId=");
		builder.append(paymentMethodId);
		builder.append(", shippingMethodId=");
		builder.append(shippingMethodId);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", total=");
		builder.append(total);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}
	
}
