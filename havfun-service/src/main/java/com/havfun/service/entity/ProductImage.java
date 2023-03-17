package com.havfun.service.entity;

import java.util.Arrays;

public class ProductImage {

	private int productImageId;
	
	private int productId;
	
	private byte[] image;
	
	private int sortingOrder;

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(int sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	@Override
	public String toString() {
		return "ProductImage [productImageId=" + productImageId + ", productId=" + productId + ", image="
				+ Arrays.toString(image) + ", sortingOrder=" + sortingOrder + "]";
	}
	
	
}
