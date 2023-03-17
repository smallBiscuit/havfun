package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum MaterialStatus {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, MaterialStatus> MATERIAL_STATUS_MAP = new HashMap<String, MaterialStatus>();
	
	static {
		for (MaterialStatus materialStatus : MaterialStatus.values()) {
			MATERIAL_STATUS_MAP.put(materialStatus.getValue(),
					materialStatus);
		}
	}
	
	private MaterialStatus(String value) {
		this.value = value;
	}
	
	public static MaterialStatus fromValue(String value) {
		return MATERIAL_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}

