package com.havfun.entity;

import com.havfun.service.data.DevicePlatform;

public class Device {
	
	private int deviceId;
	private int userId;	
	private String name;
	private DevicePlatform Platform;
	private String token;
	private long createTime;
		
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DevicePlatform getPlatform() {
		return Platform;
	}
	public void setPlatform(DevicePlatform platform) {
		Platform = platform;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", userId=" + userId
				+ ", name=" + name + ", Platform=" + Platform + ", token="
				+ token + ", createTime=" + createTime + "]";
	}

	
}
