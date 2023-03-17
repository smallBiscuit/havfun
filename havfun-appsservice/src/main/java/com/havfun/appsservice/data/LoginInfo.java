package com.havfun.appsservice.data;

public class LoginInfo {
	private long time;
	private String login;
	private String token;
	
	public LoginInfo() {
		
	}
	
	public LoginInfo(long time, String login, String token) {
		this.time = time;
		this.login = login;
		this.token = token;
	}
	
	public long getTime() {
		return this.time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginInfo [time=");
		builder.append(time);
		builder.append(", login=");
		builder.append(login);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}
}
