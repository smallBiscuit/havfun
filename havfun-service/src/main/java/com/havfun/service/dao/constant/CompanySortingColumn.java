package com.havfun.service.dao.constant;

import java.util.HashMap;
import java.util.Map;

public enum CompanySortingColumn {
	
	LISTING_DATE("listing_date"),
	
	STOCK_CODE("stock_code"),
	
	BUSINESS_CLASSIFICATION_ID("business_classification_id"),
	
	LONG_NAME_EN("long_name_en"),
	
	;
	
	private String value;
	
	private static Map<String, CompanySortingColumn> COMPANY_SORTING_COLUMN_MAP = new HashMap<String, CompanySortingColumn>();
	
	private CompanySortingColumn(String value) {
		this.value = value;
	}
	
	public static CompanySortingColumn fromValue(String value) {
		return COMPANY_SORTING_COLUMN_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
