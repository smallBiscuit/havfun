package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum UserGetPasscodeStatus {
	
	ACTIVE("A"), //
	
	EXPIRED("E"), //
	
	DONE("D"), 
	
	;
	
	private String value;
	
	private static Map<String, UserGetPasscodeStatus> USER_GET_PASSCODE_STATUS_MAP = new HashMap<String, UserGetPasscodeStatus>();
	
	static {
		for (UserGetPasscodeStatus userGetPasscodeStatus : UserGetPasscodeStatus.values()) {
			USER_GET_PASSCODE_STATUS_MAP.put(userGetPasscodeStatus.getValue(), userGetPasscodeStatus);
		}
	}
	
	private UserGetPasscodeStatus(String value) {
		this.value = value;
	}
	
	public static UserGetPasscodeStatus fromValue(String value) {
		return USER_GET_PASSCODE_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
