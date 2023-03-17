package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class EnquirePageTemplateRequest extends AbstractRequest{

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "EnquirePageTemplateRequest [key=" + key + ", clientId=" + clientId + ", token=" + token + "]";
	}

	
	
	
}
