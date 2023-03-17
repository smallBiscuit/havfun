package com.havfun.service.entity;

import java.math.BigDecimal;

import com.havfun.service.entity.constant.ProductStatus;
import com.havfun.service.entity.constant.StockStatus;

public class Product {

	private int productId;
	
	private int productGroupId;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private String thumbnailUrl;
	
	private int designerClientId;
	
	private String model;
	
	private long stock;
	
	private int manufacturerId;
	
	private BigDecimal price;
	
	private int availableDate;
	
	private BigDecimal weight;
	
	private BigDecimal length;
	
	private BigDecimal width;
	
	private BigDecimal height;
	
	private int sortingOrder;
	
	private StockStatus stockStatus;
	
	private ProductStatus productStatus;
	
	private long createTimestamp;
	
	private long lastModifiedTimestamp;


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
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

	public int getDesignerClientId() {
		return designerClientId;
	}

	public void setDesignerClientId(int designerClientId) {
		this.designerClientId = designerClientId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(int availableDate) {
		this.availableDate = availableDate;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public int getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(int sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productGroupId=" + productGroupId + ", nameEn=" + nameEn
				+ ", nameHk=" + nameHk + ", nameCn=" + nameCn + ", thumbnailUrl=" + thumbnailUrl + ", designerClientId="
				+ designerClientId + ", model=" + model + ", stock=" + stock + ", manufacturerId=" + manufacturerId
				+ ", price=" + price + ", availableDate=" + availableDate + ", weight=" + weight + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", sortingOrder=" + sortingOrder + ", stockStatus="
				+ stockStatus + ", productStatus=" + productStatus + ", createTimestamp=" + createTimestamp
				+ ", lastModifiedTimestamp=" + lastModifiedTimestamp + "]";
	}	

}
