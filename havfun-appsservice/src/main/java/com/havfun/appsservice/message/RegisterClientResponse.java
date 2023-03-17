package com.havfun.appsservice.message;

public class RegisterClientResponse extends AbstractResponse {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterClientResponse [result=");
		builder.append(result);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}


	
}
