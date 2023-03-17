package com.havfun.service.message.data;

public class ZoneToGeoZoneMessage {

	private int zoneToGeoZone;
	
	private int countryId;
	
	private int zoneId;
	
	private long createTimestamp;
	
	private long lastModifiedTimestamp;

	public int getZoneToGeoZone() {
		return zoneToGeoZone;
	}

	public void setZoneToGeoZone(int zoneToGeoZone) {
		this.zoneToGeoZone = zoneToGeoZone;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	@Override
	public String toString() {
		return "ZoneToGeoZone [zoneToGeoZone=" + zoneToGeoZone + ", countryId=" + countryId + ", zoneId=" + zoneId
				+ ", createTimestamp=" + createTimestamp + ", lastModifiedTimestamp=" + lastModifiedTimestamp + "]";
	}
	
	
	
}
