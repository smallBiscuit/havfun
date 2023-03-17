package com.havfun.service.message.data;

public class OptionMessage {

	private int orderOptionId;
	
	private String type;

	public int getOrderOptionId() {
		return orderOptionId;
	}

	public void setOrderOptionId(int orderOptionId) {
		this.orderOptionId = orderOptionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Option [option=" + orderOptionId + ", type=" + type + "]";
	}
	
}
