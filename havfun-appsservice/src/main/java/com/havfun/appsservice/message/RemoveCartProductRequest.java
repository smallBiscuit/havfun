package com.havfun.appsservice.message;

public class RemoveCartProductRequest extends AbstractRequest{

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "RemoveCartProductRequest [index=" + index + ", clientId=" + clientId + ", token=" + token + "]";
	}
	
	
	
}
