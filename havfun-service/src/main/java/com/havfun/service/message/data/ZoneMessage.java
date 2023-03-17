package com.havfun.service.message.data;

public class ZoneMessage {

	private int zoneId;
	
	private int countryId;
	
	private String name;
	
	private String code;
	
	private boolean active;

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", countryId=" + countryId + ", name=" + name + ", code=" + code + ", active="
				+ active + "]";
	}
	
	
	
}
