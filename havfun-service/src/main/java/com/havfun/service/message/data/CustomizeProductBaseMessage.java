package com.havfun.service.message.data;

import java.util.List;
import java.util.Map;

public class CustomizeProductBaseMessage {

	private int baseId;
	
	private List<CustomizeProductBaseViewMessage> views;
	
	private List<CustomizeProductColorItemMessage> colorItemList;

	private Map<String, List<ProductAttributeOptionMessage>> variations;
	
	public int getBaseId() {
		return baseId;
	}

	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}

	public List<CustomizeProductBaseViewMessage> getViews() {
		return views;
	}

	public void setViews(List<CustomizeProductBaseViewMessage> views) {
		this.views = views;
	}

	public List<CustomizeProductColorItemMessage> getColorItemList() {
		return colorItemList;
	}

	public void setColorItemList(List<CustomizeProductColorItemMessage> colorItemList) {
		this.colorItemList = colorItemList;
	}
	
	public Map<String, List<ProductAttributeOptionMessage>> getVariations() {
		return variations;
	}

	public void setVariations(Map<String, List<ProductAttributeOptionMessage>> variations) {
		this.variations = variations;
	}

	@Override
	public String toString() {
		return "CustomizeProductBaseMessage [baseId=" + baseId + ", views=" + views + ", colorItemList=" + colorItemList
				+ ", variations=" + variations + "]";
	}

	
}
