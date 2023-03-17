package com.havfun.entity;

public class Notification {

	private int notificationId;
	private int userId;
	private int type;
	private String message;

	
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
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
		return "Notification [notificationId=" + notificationId + ", userId="
				+ userId + ", type=" + type + ", message=" + message + "]";
	}
	
		
}
