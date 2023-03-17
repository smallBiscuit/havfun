package com.havfun.service.entity;

import java.math.BigDecimal;

public class CustomizeProductBaseView {

	private int viewId;
	
	private int baseId;
	
	private String title;
	
	private long boundWidth;
	
	private long boundHeight;
	
	private int z;
	
	private BigDecimal scale;

	
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

	public long getBoundWidth() {
		return boundWidth;
	}

	public void setBoundWidth(long boundWidth) {
		this.boundWidth = boundWidth;
	}

	public long getBoundHeight() {
		return boundHeight;
	}

	public void setBoundHeight(long boundHeight) {
		this.boundHeight = boundHeight;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomizeProductBaseView [viewId=");
		builder.append(viewId);
		builder.append(", baseId=");
		builder.append(baseId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", boundWidth=");
		builder.append(boundWidth);
		builder.append(", boundHeight=");
		builder.append(boundHeight);
		builder.append(", z=");
		builder.append(z);
		builder.append(", scale=");
		builder.append(scale);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}
