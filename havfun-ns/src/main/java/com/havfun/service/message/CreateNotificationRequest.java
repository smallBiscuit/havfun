package com.havfun.service.message;

public class CreateNotificationRequest extends AbstractRequest {

	private int userId;
	private int type;
	private String message;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CreateNotificationRequest [userId=" + userId + ", type=" + type
				+ ", message=" + message + "]";
	}
	
	
	
}
