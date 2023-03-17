package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum Gender {

	N_A("N"),
	
	MALE("M"),
	
	FEMALE("F"),
	
	;
	
	private String value;
	
	private static Map<String, Gender> GENDER_MAP = new HashMap<String, Gender>();
	
	static {
		for (Gender gender : Gender.values()) {
			GENDER_MAP.put(gender.getValue(),
					gender);
		}
	}
	
	private Gender(String value) {
		this.value = value;
	}
	
	public static Gender fromValue(String value) {
		return GENDER_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
