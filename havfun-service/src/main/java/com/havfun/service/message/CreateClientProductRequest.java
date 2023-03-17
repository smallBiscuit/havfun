package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class CreateClientProductRequest extends AbstractRequest{
	
	private int productBaseId;
	
	private String fileBase64Data;
	
	public CreateClientProductRequest() {
		setMessageId(MessageId.CREATE_CLIENT_PRODUCT_REQUEST);
	}

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
		builder.append("CreateClientProductRequest [productBaseId=");
		builder.append(productBaseId);
		builder.append(", fileBase64Data=");
		builder.append(fileBase64Data);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

	
	


}

