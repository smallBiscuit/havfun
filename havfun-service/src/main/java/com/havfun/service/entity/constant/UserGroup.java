package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum UserGroup {
	
	ADMIN("AD"),
	
	OPERATOR("OP")
	
	;
	
	private String value;
	
	private static Map<String, UserGroup> USER_ROLE_MAP = new HashMap<String, UserGroup>();
	
	static {
		for (UserGroup userGroup : UserGroup.values()) {
			USER_ROLE_MAP.put(userGroup.getValue(),
					userGroup);
		}
	}
	
	private UserGroup(String value) {
		this.value = value;
	}

	public static UserGroup fromValue(String value) {
		return USER_ROLE_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
