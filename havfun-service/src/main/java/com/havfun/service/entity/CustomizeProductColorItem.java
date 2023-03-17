package com.havfun.service.entity;

public class CustomizeProductColorItem {

	private int colorId;
	
	private int baseId;
	
	private String fileType;
	
	private String imageUrl;
	
	private String parentImage;

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getBaseId() {
		return baseId;
	}

	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getParentImage() {
		return parentImage;
	}

	public void setParentImage(String parentImage) {
		this.parentImage = parentImage;
	}

	@Override
	public String toString() {
		return "CustomizeProductColorItem [colorId=" + colorId + ", baseId=" + baseId + ", fileType=" + fileType
				+ ", imageUrl=" + imageUrl + ", parentImage=" + parentImage + "]";
	}
	
	
}
