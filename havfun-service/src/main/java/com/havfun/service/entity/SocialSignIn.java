package com.havfun.service.entity;

public class SocialSignIn {

	private int socialSignInId;
	
	private int clientId;
	
	private String email;
	
	private String prvoider;
	
	private String identifier;
	
	private long registerTimestamp;
	
	private long lastVisitTimestamp;

	public int getSocialSignInId() {
		return socialSignInId;
	}

	public void setSocialSignInId(int socialSignInId) {
		this.socialSignInId = socialSignInId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrvoider() {
		return prvoider;
	}

	public void setPrvoider(String prvoider) {
		this.prvoider = prvoider;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public long getRegisterTimestamp() {
		return registerTimestamp;
	}

	public void setRegisterTimestamp(long registerTimestamp) {
		this.registerTimestamp = registerTimestamp;
	}

	public long getLastVisitTimestamp() {
		return lastVisitTimestamp;
	}

	public void setLastVisitTimestamp(long lastVisitTimestamp) {
		this.lastVisitTimestamp = lastVisitTimestamp;
	}

	@Override
	public String toString() {
		return "SocialSignIn [socialSignInId=" + socialSignInId + ", clientId=" + clientId + ", email=" + email
				+ ", prvoider=" + prvoider + ", identifier=" + identifier + ", registerTimestamp=" + registerTimestamp
				+ ", lastVisitTimestamp=" + lastVisitTimestamp + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
