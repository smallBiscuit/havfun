package com.havfun.service.message.data;

import java.math.BigDecimal;
import java.util.List;

public class CustomizeProductBaseViewMessage {

	private int viewId;
	
	private int baseId;
	
	private String title;
	
	private List<CustomizeProductBorderItemMessage> borderList;
	
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

	
	
	public List<CustomizeProductBorderItemMessage> getBorderList() {
		return borderList;
	}

	public void setBorderList(List<CustomizeProductBorderItemMessage> borderList) {
		this.borderList = borderList;
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
		builder.append("CustomizeProductBaseViewMessage [viewId=");
		builder.append(viewId);
		builder.append(", baseId=");
		builder.append(baseId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", borderList=");
		builder.append(borderList);
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
