package com.havfun.appsservice.message;

import com.havfun.appsservice.data.DevicePlatform;
import com.havfun.service.message.AbstractRequest;

public class RegisterDeviceRequest extends AbstractRequest{

	private int userId;
	private String name;
	private DevicePlatform platform;	
	private String token;
	
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
		return platform;
	}
	public void setPlatform(DevicePlatform platform) {
		this.platform = platform;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "RegisterDeviceRequest [userId=" + userId + ", name=" + name
				+ ", platform=" + platform + ", token=" + token + "]";
	}
	
}
