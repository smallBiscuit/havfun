package com.havfun.appsservice.message;

import java.util.Map;

public class CreateCartProductRequest extends AbstractRequest{

	private int productId;
	
	private long quantity;
	
	private Map<String, String> optionMap;
	
	private String designInfo;

	private String fileName;
	
	private String fileBase64Data;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Map<String, String> getOptionMap() {
		return optionMap;
	}

	public void setOptionsMap(Map<String, String> optionMap) {
		this.optionMap = optionMap;
	}

	public String getDesignInfo() {
		return designInfo;
	}

	public void setDesignInfo(String designInfo) {
		this.designInfo = designInfo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileBase64Data() {
		return fileBase64Data;
	}

	public void setFileBase64Data(String fileBase64Data) {
		this.fileBase64Data = fileBase64Data;
	}

	@Override
	public String toString() {
		return "CreateCartProductRequest [productId=" + productId + ", quantity=" + quantity + ", optionMap="
				+ optionMap + ", designInfo=" + designInfo + ", fileName=" + fileName + ", fileBase64Data="
				+ fileBase64Data + ", clientId=" + clientId + ", token=" + token + "]";
	}

	
	
}
