package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum LoginStatus {
	
	LOGIN("I"),
	
	LOGOUT("O"),
	
	FAIL("F"),
	
	;
	
	private String value;
	
	private static Map<String, LoginStatus> LOGIN_STATUS_MAP = new HashMap<String, LoginStatus>();
	
	static {
		for (LoginStatus loginStatus : LoginStatus.values()) {
			LOGIN_STATUS_MAP.put(loginStatus.getValue(),
					loginStatus);
		}
	}
	
	private LoginStatus(String value) {
		this.value = value;
	}
	
	public static LoginStatus fromValue(String value) {
		return LOGIN_STATUS_MAP.get(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
