package com.havfun.service.entity;

import java.util.Arrays;

public class Material {

	private int materialId;
	
	private byte[] image;	

	private int materialGroupId;
	
	private int materialIndex;
	
	private boolean active;
	
	private long createTimestamp;

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Material [materialId=");
		builder.append(materialId);
		builder.append(", image=");
		builder.append( image!=null?image.length:"");
		builder.append(", materialGroupId=");
		builder.append(materialGroupId);
		builder.append(", materialIndex=");
		builder.append(materialIndex);
		builder.append(", active=");
		builder.append(active);
		builder.append(", createTimestamp=");
		builder.append(createTimestamp);
		builder.append("]");
		return builder.toString();
	}

	

}
