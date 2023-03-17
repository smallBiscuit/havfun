package com.havfun.appsservice.data;

public class PaymentMethod {

	private int methodId;
	
	private String title;
	
	private String receiverId;
	
	public int getMethodId() {
		return methodId;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	
	@Override
	public String toString() {
		return "PaymentMethod [methodId=" + methodId + ", title=" + title + ", receiverId=" + receiverId + "]";
	}
	
}
