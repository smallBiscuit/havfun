package com.havfun.appsservice.message;

public class UploadClientProductImageResponse extends AbstractResponse{

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadClientProductImageResponse [result=");
		builder.append(result);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}

	
}
