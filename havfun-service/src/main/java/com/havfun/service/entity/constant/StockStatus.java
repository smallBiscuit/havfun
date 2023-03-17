package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum StockStatus {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, StockStatus> STOCK_STATUS_MAP = new HashMap<String, StockStatus>();
	
	static {
		for (StockStatus stockStatus : StockStatus.values()) {
			STOCK_STATUS_MAP.put(stockStatus.getValue(),
					stockStatus);
		}
	}
	
	private StockStatus(String value) {
		this.value = value;
	}
	
	public static StockStatus fromValue(String value) {
		return STOCK_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
