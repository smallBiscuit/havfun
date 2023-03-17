package com.havfun.service.message;

public class AbstractResponse {

	int result;
	String reason;
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "AbstractResponse [result=" + result + ", reason=" + reason
				+ "]";
	}

	

}
