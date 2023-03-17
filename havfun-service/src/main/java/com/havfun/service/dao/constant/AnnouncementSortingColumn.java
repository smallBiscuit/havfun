package com.havfun.service.dao.constant;

import java.util.HashMap;
import java.util.Map;

public enum AnnouncementSortingColumn {
	
	RELEASE_TIMESTAMP("release_timestamp"),
	
	STOCK_CODE("stock_code"),
	
	ANNOUNCEMENT_TYPE("announcement_type_code"),
	
	;
	
	private String value;
	
	private static Map<String, AnnouncementSortingColumn> ANNOUNCEMENT_SORTING_COLUMN_MAP = new HashMap<String, AnnouncementSortingColumn>();
	
	private AnnouncementSortingColumn(String value) {
		this.value = value;
	}
	
	public static AnnouncementSortingColumn fromValue(String value) {
		return ANNOUNCEMENT_SORTING_COLUMN_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
