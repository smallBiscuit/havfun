package com.havfun.appsservice.message;

public class UploadClientProductRequest extends AbstractRequest{

	private int productBaseId;
	
	private String fileBase64Data;

	public int getProductBaseId() {
		return productBaseId;
	}

	public void setProductBaseId(int productBaseId) {
		this.productBaseId = productBaseId;
	}

	public String getFileBase64Data() {
		return fileBase64Data;
	}

	public void setFileBase64Data(String fileBase64Data) {
		this.fileBase64Data = fileBase64Data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadClientProductRequest [productBaseId=");
		builder.append(productBaseId);
		builder.append(", fileBase64Data=");
		builder.append(fileBase64Data);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}
	
	
}
