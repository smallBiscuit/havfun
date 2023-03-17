package com.havfun.appsservice.data;

import java.util.List;
import java.util.Map;


public class CustomizeProductBase {

	private int baseId;
	
	private List<CustomizeProductBaseView> views;
	
	private List<CustomizeProductColorItem> baseColor;

	private List<ProductAttribute> attributeList;
	
	public int getBaseId() {
		return baseId;
	}

	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}

	public List<CustomizeProductBaseView> getViews() {
		return views;
	}

	public void setViews(List<CustomizeProductBaseView> views) {
		this.views = views;
	}

	public List<CustomizeProductColorItem> getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(List<CustomizeProductColorItem> baseColor) {
		this.baseColor = baseColor;
	}

	public List<ProductAttribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<ProductAttribute> attributeList) {
		this.attributeList = attributeList;
	}

	@Override
	public String toString() {
		return "CustomizeProductBase [baseId=" + baseId + ", views=" + views + ", baseColor=" + baseColor
				+ ", attributeList=" + attributeList + "]";
	}

	
	
	
}
