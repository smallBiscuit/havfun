package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum LanguageFlag {
	
	ENGLISH("E"),
	
	CHINESE("C"),
	
	;
	
	private String value;
	
	private static Map<String, LanguageFlag> LAUNGAGE_FLAG_MAP = new HashMap<String, LanguageFlag>();
	
	static {
		for (LanguageFlag languageFlag : LanguageFlag.values()) {
			LAUNGAGE_FLAG_MAP.put(languageFlag.getValue(),
					languageFlag);
		}
	}
	
	private LanguageFlag(String value) {
		this.value = value;
	}
	
	public static LanguageFlag fromValue(String value) {
		return LAUNGAGE_FLAG_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
