package com.havfun.appsservice.message;

public class UploadClientProductResponse extends AbstractResponse{

	private int clientProductId;

	public int getClientProductId() {
		return clientProductId;
	}

	public void setClientProductId(int clientProductId) {
		this.clientProductId = clientProductId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadClientProductResponse [clientProductId=");
		builder.append(clientProductId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}
	
	
}
