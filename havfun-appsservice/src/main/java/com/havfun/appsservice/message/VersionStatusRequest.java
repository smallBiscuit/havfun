package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class VersionStatusRequest extends AbstractRequest{

	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VersionStatusRequest [version=" + version + ", clientId=" + clientId + ", token=" + token + "]";
	}

	
}
