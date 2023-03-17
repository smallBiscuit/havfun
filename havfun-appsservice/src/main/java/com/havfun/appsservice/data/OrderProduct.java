package com.havfun.appsservice.data;

public class OrderProduct extends OrderProductBase {

	private int orderProductId;
	
	private String name;
	
	private String model;

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderProduct [orderProductId=");
		builder.append(orderProductId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}

	
}
