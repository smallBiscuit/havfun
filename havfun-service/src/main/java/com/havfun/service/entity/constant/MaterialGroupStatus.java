package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum MaterialGroupStatus {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, MaterialGroupStatus> MATERIAL_GROUP_STATUS_MAP = new HashMap<String, MaterialGroupStatus>();
	
	static {
		for (MaterialGroupStatus materialGroupStatus : MaterialGroupStatus.values()) {
			MATERIAL_GROUP_STATUS_MAP.put(materialGroupStatus.getValue(),
					materialGroupStatus);
		}
	}
	
	private MaterialGroupStatus(String value) {
		this.value = value;
	}
	
	public static MaterialGroupStatus fromValue(String value) {
		return MATERIAL_GROUP_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
