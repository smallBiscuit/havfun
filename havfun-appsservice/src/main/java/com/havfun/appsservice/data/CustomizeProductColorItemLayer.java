package com.havfun.appsservice.data;

public class CustomizeProductColorItemLayer {
	
	private String colorThumbnail;
	
	private String fileType;
	
	private String imageURL;
	
	private String parentImage;

	public String getColorThumbnail() {
		return colorThumbnail;
	}

	public void setColorThumbnail(String colorThumbnail) {
		this.colorThumbnail = colorThumbnail;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getParentImage() {
		return parentImage;
	}

	public void setParentImage(String parentImage) {
		this.parentImage = parentImage;
	}

	@Override
	public String toString() {
		return "CustomizeProductColorItemLayer [colorThumbnail=" + colorThumbnail + ", fileType=" + fileType
				+ ", imageURL=" + imageURL + ", parentImage=" + parentImage + "]";
	}

	

}
