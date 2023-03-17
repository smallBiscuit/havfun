package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {

	PENDING("P"),
	
	CONFIRMED("C"),
	
	REJECTED("R"),
	
	SHIPPED("S"),
	
	FINISH("F"),
	
	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, OrderStatus> ORDER_STATUS_MAP = new HashMap<String, OrderStatus>();
	
	static {
		for (OrderStatus orderStatus : OrderStatus.values()) {
			ORDER_STATUS_MAP.put(orderStatus.getValue(),
					orderStatus);
		}
	}
	
	private OrderStatus(String value) {
		this.value = value;
	}
	
	public static OrderStatus fromValue(String value) {
		return ORDER_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
