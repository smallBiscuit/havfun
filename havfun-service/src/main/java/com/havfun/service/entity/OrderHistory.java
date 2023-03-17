package com.havfun.service.entity;

import com.havfun.service.entity.constant.OrderStatus;

public class OrderHistory {

	private int orderHistoryId;
	
	private int orderId;
	
	private OrderStatus status;
	
	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", status=" + status
				+ ", remark=" + remark + ", createTimestamp=" + createTimestamp + "]";
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	private String remark;
	
	private long createTimestamp;
	
	
	
}
