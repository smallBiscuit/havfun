package com.havfun.service.message.data;

import java.util.Arrays;

public class MaterialGroupMessage {

	private int materialGroupId;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private byte[] image;
	
	private int parentId;
	
	private boolean active;
	
	private long createTimestamp;
	
	private long lastModifiedTimestamp;

	public int getMaterialGroupId() {
		return materialGroupId;
	}

	public void setMaterialGroupId(int materialGroupId) {
		this.materialGroupId = materialGroupId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameHk() {
		return nameHk;
	}

	public void setNameHk(String nameHk) {
		this.nameHk = nameHk;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
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

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MaterialGroupMessage [materialGroupId=");
		builder.append(materialGroupId);
		builder.append(", nameEn=");
		builder.append(nameEn);
		builder.append(", nameHk=");
		builder.append(nameHk);
		builder.append(", nameCn=");
		builder.append(nameCn);
		builder.append(", image=");
		builder.append( image!=null?image.length:"");
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", active=");
		builder.append(active);
		builder.append(", createTimestamp=");
		builder.append(createTimestamp);
		builder.append(", lastModifiedTimestamp=");
		builder.append(lastModifiedTimestamp);
		builder.append("]");
		return builder.toString();
	}

	
}

