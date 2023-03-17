package com.havfun.appsservice.data;

import java.math.BigDecimal;

public class CustomizeProductBorderItem {

	private int borderId;

	private int viewId;
	
	private String itemKey;
	
	private String itemType;
	
	private String title;
	
	private boolean defaultOption;
	
	private BigDecimal cost;

	private long x;
	
	private long y;
	
	private long width;	
	
	private long height;

	public int getBorderId() {
		return borderId;
	}

	public void setBorderId(int borderId) {
		this.borderId = borderId;
	}

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

	public String getItemKey() {
		return itemKey;
	}

	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDefaultOption() {
		return defaultOption;
	}

	public void setDefaultOption(boolean defaultOption) {
		this.defaultOption = defaultOption;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomizeProductBorderItem [borderId=");
		builder.append(borderId);
		builder.append(", viewId=");
		builder.append(viewId);
		builder.append(", itemKey=");
		builder.append(itemKey);
		builder.append(", itemType=");
		builder.append(itemType);
		builder.append(", title=");
		builder.append(title);
		builder.append(", defaultOption=");
		builder.append(defaultOption);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

	
}
