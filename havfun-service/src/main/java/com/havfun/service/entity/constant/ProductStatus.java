package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum ProductStatus {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, ProductStatus> PRODUCT_STATUS_MAP = new HashMap<String, ProductStatus>();
	
	static {
		for (ProductStatus productStatus : ProductStatus.values()) {
			PRODUCT_STATUS_MAP.put(productStatus.getValue(),
					productStatus);
		}
	}
	
	private ProductStatus(String value) {
		this.value = value;
	}
	
	public static ProductStatus fromValue(String value) {
		return PRODUCT_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
