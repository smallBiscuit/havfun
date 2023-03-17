package com.havfun.service.message;

public class AbstractResponse extends AbstractMessage {
	
	protected int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
