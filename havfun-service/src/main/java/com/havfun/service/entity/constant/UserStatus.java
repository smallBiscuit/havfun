package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus {
	
	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, UserStatus> USER_STATUS_MAP = new HashMap<String, UserStatus>();
	
	static {
		for (UserStatus userStatus : UserStatus.values()) {
			USER_STATUS_MAP.put(userStatus.getValue(),
					userStatus);
		}
	}
	
	private UserStatus(String value) {
		this.value = value;
	}
	
	public static UserStatus fromValue(String value) {
		return USER_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
