package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Product;
import com.havfun.service.message.data.ProductMessage;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.entity.constant.ProductStatus;

public class ProductConvertor {

	public final static List<Product> convertToEntityList(List<ProductMessage> productMessageList) {
		if (productMessageList == null) {
			return null;
		}

		List<Product> productList = new ArrayList<Product>();
		for (ProductMessage productMessage : productMessageList) {
			productList.add(convertToEntity(productMessage));
		}

		return productList;
	}

	public final static List<ProductMessage> convertToMessageList(List<Product> productList) {
		if (productList == null) {
			return null;
		}

		List<ProductMessage> productMessageList = new ArrayList<ProductMessage>();
		for (Product product : productList) {
			productMessageList.add(convertToMessage(product));
		}

		return productMessageList;
	}

	public final static Product convertToEntity(ProductMessage productMessage) {
		Product product = new Product();

		product.setProductId(productMessage.getProductId());
		product.setProductGroupId(productMessage.getProductGroupId());
		product.setNameEn(productMessage.getNameEn());
		product.setNameHk(productMessage.getNameHk());
		product.setNameCn(productMessage.getNameCn());
		product.setThumbnailUrl(productMessage.getThumbnailUrl());
		product.setDesignerClientId(productMessage.getDesignerClientId());
		product.setModel(productMessage.getModel());
		product.setStock(productMessage.getStock());
		product.setManufacturerId(productMessage.getManufacturerId());
		product.setPrice(productMessage.getPrice());
		product.setAvailableDate(productMessage.getAvailableDate());
		product.setWeight(productMessage.getWeight());
		product.setLength(productMessage.getLength());
		product.setWidth(productMessage.getWidth());
		product.setHeight(productMessage.getHeight());
		product.setSortingOrder(productMessage.getSortingOrder());
		product.setStockStatus(productMessage.getStockStatus());
		product.setProductStatus(productMessage.getProductStatus());
		product.setCreateTimestamp(productMessage.getCreateTimestamp());
		product.setLastModifiedTimestamp(productMessage.getLastModifiedTimestamp());

		return product;
	}

	public final static ProductMessage convertToMessage(Product product) {
		ProductMessage productMessage = new ProductMessage();

		productMessage.setProductId(product.getProductId());
		productMessage.setProductGroupId(product.getProductGroupId());
		productMessage.setNameEn(product.getNameEn());
		productMessage.setNameHk(product.getNameHk());
		productMessage.setNameCn(product.getNameCn());
		productMessage.setThumbnailUrl(product.getThumbnailUrl());
		productMessage.setDesignerClientId(product.getDesignerClientId());
		productMessage.setModel(product.getModel());
		productMessage.setStock(product.getStock());
		productMessage.setManufacturerId(product.getManufacturerId());
		productMessage.setPrice(product.getPrice());
		productMessage.setAvailableDate(product.getAvailableDate());
		productMessage.setWeight(product.getWeight());
		productMessage.setLength(product.getLength());
		productMessage.setWidth(product.getWidth());
		productMessage.setHeight(product.getHeight());
		productMessage.setSortingOrder(product.getSortingOrder());
		productMessage.setStockStatus(product.getStockStatus());
		productMessage.setProductStatus(product.getProductStatus());
		productMessage.setCreateTimestamp(product.getCreateTimestamp());
		productMessage.setLastModifiedTimestamp(product.getLastModifiedTimestamp());

		return productMessage;
	}

}


