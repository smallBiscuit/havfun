package com.havfun.appsservice.data;

import java.util.List;

public class CustomizeProductBaseView {

	private int viewId;
	
	private int baseId;
	
	private String title;
	
	private List<CustomizeProductBorderItem> boundingList;

	private List<CustomizeProductBaseViewElements> elements;
	
	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

	public int getBaseId() {
		return baseId;
	}

	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CustomizeProductBorderItem> getBoundingList() {
		return boundingList;
	}

	public void setBoundingList(List<CustomizeProductBorderItem> boundingList) {
		this.boundingList = boundingList;
	}

	public List<CustomizeProductBaseViewElements> getElements() {
		return elements;
	}

	public void setElements(List<CustomizeProductBaseViewElements> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "CustomizeProductBaseView [viewId=" + viewId + ", baseId=" + baseId + ", title=" + title
				+ ", boundingList=" + boundingList + ", elements=" + elements + "]";
	}

	

	
	
}
