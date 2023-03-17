package com.havfun.appsservice.data;

import java.math.BigDecimal;
import java.util.List;

import com.havfun.service.entity.constant.OrderStatus;
import com.havfun.service.message.data.OrderProductMessage;

public class Order {

	private int orderId;
	
	private String invoiceNo;
	
	private int storeId;
	
	private String storeName;
	
	private String storeUrl;
	
	private int clientId;
	
	private String clientGroup;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String telephone;
	
	private String fax;
	
	private List<OrderProduct> orderProductList;
	
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
	
	private int currencyId;
	
	private String currencyCode;
	
	private BigDecimal currencyValue;
	
	private String remark;
	
	private BigDecimal total;
	
	private OrderStatus status;
	
	private long createTimestamp;
	
	private long lastModifiedTimestamp;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientGroup() {
		return clientGroup;
	}

	public void setClientGroup(String clientGroup) {
		this.clientGroup = clientGroup;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
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

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=");
		builder.append(orderId);
		builder.append(", invoiceNo=");
		builder.append(invoiceNo);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", storeName=");
		builder.append(storeName);
		builder.append(", storeUrl=");
		builder.append(storeUrl);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", clientGroup=");
		builder.append(clientGroup);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", orderProductList=");
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
		builder.append(", currencyId=");
		builder.append(currencyId);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append(", currencyValue=");
		builder.append(currencyValue);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", total=");
		builder.append(total);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createTimestamp=");
		builder.append(createTimestamp);
		builder.append(", lastModifiedTimestamp=");
		builder.append(lastModifiedTimestamp);
		builder.append("]");
		return builder.toString();
	}

	
	
}
