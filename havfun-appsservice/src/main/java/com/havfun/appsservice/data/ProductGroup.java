package com.havfun.appsservice.data;

public class ProductGroup {

	private int groupId;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private String thumbnailUrl;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
		return "ProductGroup [groupId=" + groupId + ", nameEn=" + nameEn + ", nameHk=" + nameHk + ", nameCn=" + nameCn
				+ ", thumbnailUrl=" + thumbnailUrl + "]";
	}


	
}
