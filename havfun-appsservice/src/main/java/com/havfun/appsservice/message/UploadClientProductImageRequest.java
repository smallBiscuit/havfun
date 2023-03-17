package com.havfun.appsservice.message;

import java.util.Arrays;

public class UploadClientProductImageRequest extends AbstractRequest{

	private int clientProductId;
	
	private int viewIndex;
	
	private int layerIndex;

	private String fileBase64Data;
	
	public int getClientProductId() {
		return clientProductId;
	}

	public void setClientProductId(int clientProductId) {
		this.clientProductId = clientProductId;
	}

	public int getViewIndex() {
		return viewIndex;
	}

	public void setViewIndex(int viewIndex) {
		this.viewIndex = viewIndex;
	}

	public int getLayerIndex() {
		return layerIndex;
	}

	public void setLayerIndex(int layerIndex) {
		this.layerIndex = layerIndex;
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
		builder.append("UploadClientProductImageRequest [clientProductId=");
		builder.append(clientProductId);
		builder.append(", viewIndex=");
		builder.append(viewIndex);
		builder.append(", layerIndex=");
		builder.append(layerIndex);
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
