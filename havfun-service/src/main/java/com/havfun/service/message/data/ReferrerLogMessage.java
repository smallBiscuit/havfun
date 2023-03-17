package com.havfun.service.message.data;

import java.math.BigDecimal;

public class ReferrerLogMessage {

	private int logId;
	
	private int clientId;
	
	private int referrer;
	
	private int orderId;
	
	private BigDecimal total;
	
	private BigDecimal price;
	
	private long createTimestamp;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getReferrer() {
		return referrer;
	}

	public void setReferrer(int referrer) {
		this.referrer = referrer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Override
	public String toString() {
		return "ReferrerLog [logId=" + logId + ", clientId=" + clientId + ", referrer=" + referrer + ", orderId="
				+ orderId + ", total=" + total + ", price=" + price + ", createTimestamp=" + createTimestamp + "]";
	}
	
	
	
}
