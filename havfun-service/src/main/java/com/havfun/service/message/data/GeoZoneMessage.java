package com.havfun.service.message.data;

public class GeoZoneMessage {

	private int geoZeonId;
	
	private String name;
	
	private String description;
	
	private long createTimestamp;
	
	private long lastModifedTimestamp;

	public int getGeoZeonId() {
		return geoZeonId;
	}

	public void setGeoZeonId(int geoZeonId) {
		this.geoZeonId = geoZeonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public long getLastModifedTimestamp() {
		return lastModifedTimestamp;
	}

	public void setLastModifedTimestamp(long lastModifedTimestamp) {
		this.lastModifedTimestamp = lastModifedTimestamp;
	}

	@Override
	public String toString() {
		return "GeoZone [geoZeonId=" + geoZeonId + ", name=" + name + ", description=" + description
				+ ", createTimestamp=" + createTimestamp + ", lastModifedTimestamp=" + lastModifedTimestamp + "]";
	}
	
	
}
