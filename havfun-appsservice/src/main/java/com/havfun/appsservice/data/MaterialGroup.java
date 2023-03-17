package com.havfun.appsservice.data;

public class MaterialGroup {

	private int materialGroupId;

	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private String thumbnailUrl;

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

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MaterialGroup [materialGroupId=");
		builder.append(materialGroupId);
		builder.append(", nameEn=");
		builder.append(nameEn);
		builder.append(", nameHk=");
		builder.append(nameHk);
		builder.append(", nameCn=");
		builder.append(nameCn);
		builder.append(", thumbnailUrl=");
		builder.append(thumbnailUrl);
		builder.append("]");
		return builder.toString();
	}
	
}
