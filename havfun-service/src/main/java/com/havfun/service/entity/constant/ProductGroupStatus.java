package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum ProductGroupStatus {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, ProductGroupStatus> PRODUCT_GROUP_STATUS_MAP = new HashMap<String, ProductGroupStatus>();
	
	static {
		for (ProductGroupStatus productGroupStatus : ProductGroupStatus.values()) {
			PRODUCT_GROUP_STATUS_MAP.put(productGroupStatus.getValue(),
					productGroupStatus);
		}
	}
	
	private ProductGroupStatus(String value) {
		this.value = value;
	}
	
	public static ProductGroupStatus fromValue(String value) {
		return PRODUCT_GROUP_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
