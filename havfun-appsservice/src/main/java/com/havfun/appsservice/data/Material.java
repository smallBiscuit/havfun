package com.havfun.appsservice.data;

public class Material {

	private int materialId;
	
	private String thumbnailUrl;

	private int materialGroupId;
	
	private int materialIndex;

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public int getMaterialGroupId() {
		return materialGroupId;
	}

	public void setMaterialGroupId(int materialGroupId) {
		this.materialGroupId = materialGroupId;
	}

	public int getMaterialIndex() {
		return materialIndex;
	}

	public void setMaterialIndex(int materialIndex) {
		this.materialIndex = materialIndex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Material [materialId=");
		builder.append(materialId);
		builder.append(", thumbnailUrl=");
		builder.append(thumbnailUrl);
		builder.append(", materialGroupId=");
		builder.append(materialGroupId);
		builder.append(", materialIndex=");
		builder.append(materialIndex);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
