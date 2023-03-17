package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum LabelType {
	
	PRODUCT_NAME("product_name"),
	
	PRODUCT_DESCRIPTION("product_description"),
	
	;
	
	private String value;
	
	private static Map<String, LabelType> LABEL_TYPE_MAP = new HashMap<String, LabelType>();
	
	static {
		for (LabelType labelType : LabelType.values()) {
			LABEL_TYPE_MAP.put(labelType.getValue(),
					labelType);
		}
	}
	
	private LabelType(String value) {
		this.value = value;
	}
	
	public static LabelType fromValue(String value) {
		return LABEL_TYPE_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}

