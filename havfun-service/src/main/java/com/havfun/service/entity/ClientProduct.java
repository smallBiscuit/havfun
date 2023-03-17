package com.havfun.service.entity;

import com.havfun.service.entity.constant.ProductStatus;
import com.havfun.service.entity.constant.StockStatus;

public class ClientProduct {

	private int clientProductId;
	
	private int designerClientId;
	
	private ProductStatus productStatus;
	
	private long createTimestamp;
	
	private long lastModifiedTimestamp;

	public int getClientProductId() {
		return clientProductId;
	}

	public void setClientProductId(int clientProductId) {
		this.clientProductId = clientProductId;
	}

	public int getDesignerClientId() {
		return designerClientId;
	}

	public void setDesignerClientId(int designerClientId) {
		this.designerClientId = designerClientId;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientProduct [clientProductId=");
		builder.append(clientProductId);
		builder.append(", designerClientId=");
		builder.append(designerClientId);
		builder.append(", productStatus=");
		builder.append(productStatus);
		builder.append(", createTimestamp=");
		builder.append(createTimestamp);
		builder.append(", lastModifiedTimestamp=");
		builder.append(lastModifiedTimestamp);
		builder.append("]");
		return builder.toString();
	}



}

