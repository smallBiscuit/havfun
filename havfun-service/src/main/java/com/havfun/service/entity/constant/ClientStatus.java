package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum ClientStatus {
	
	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, ClientStatus> CLIENT_STATUS_MAP = new HashMap<String, ClientStatus>();
	
	static {
		for (ClientStatus clientStatus : ClientStatus.values()) {
			CLIENT_STATUS_MAP.put(clientStatus.getValue(),
					clientStatus);
		}
	}
	
	private ClientStatus(String value) {
		this.value = value;
	}
	
	public static ClientStatus fromValue(String value) {
		return CLIENT_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
