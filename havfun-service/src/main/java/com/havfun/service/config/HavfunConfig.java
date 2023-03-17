package com.havfun.service.config;

public class HavfunConfig {
	
	private String generatePasswordUrl;
	
	private String loginUrl;
	
	public String getGeneratePasswordUrl() {
		return generatePasswordUrl;
	}

	public void setGeneratePasswordUrl(String generatePasswordUrl) {
		this.generatePasswordUrl = generatePasswordUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HavfunConfig [generatePasswordUrl=");
		builder.append(generatePasswordUrl);
		builder.append(", loginUrl=");
		builder.append(loginUrl);
		builder.append("]");
		return builder.toString();
	}
	
}
