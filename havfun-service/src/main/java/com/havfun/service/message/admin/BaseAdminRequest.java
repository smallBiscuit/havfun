package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractRequest;

public class BaseAdminRequest extends AbstractRequest {
	
	protected int loginUserId;
	
	protected String token;

	public int getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(int loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
