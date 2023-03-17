package com.havfun.service.message.data;

import com.havfun.service.entity.constant.ProductGroupStatus;

public class ProductGroupMessage {

	private int productGroupId;
	
	private String nameEn;
	
	private byte[] image;
	
	private int parentId;
	
	private ProductGroupStatus status;
	
	private long createTimestamp;
	
	private long lastModifiedTimestamp;

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public ProductGroupStatus getStatus() {
		return status;
	}

	public void setStatus(ProductGroupStatus status) {
		this.status = status;
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
		
		String imageLength = "null";
		
		if ( image != null ){
			imageLength = String.valueOf( image.length );
		}
		
		return "ProductGroupMessage [productGroupId=" + productGroupId + ", nameEn=" + nameEn + ", image.length="
				+ imageLength + ", parentId=" + parentId + ", status=" + status + ", createTimestamp="
				+ createTimestamp + ", lastModifiedTimestamp=" + lastModifiedTimestamp + "]";
	}


	
}
