package com.havfun.appsservice.data;

import java.math.BigDecimal;

public class CustomizeProductBaseViewElementsParams {

	private long boundWidth;
	
	private long boundHeight;
	
	private int x;
	
	private int y;
	
	private int z;
	
	private BigDecimal scale;

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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		return "CustomizeProductBaseViewElementsParams [boundWidth=" + boundWidth + ", boundHeight=" + boundHeight
				+ ", x=" + x + ", y=" + y + ", z=" + z + ", scale=" + scale + "]";
	}
	
	
}
