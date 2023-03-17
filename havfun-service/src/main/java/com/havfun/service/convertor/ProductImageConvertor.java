package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ProductImage;
import com.havfun.service.message.data.ProductImageMessage;

public class ProductImageConvertor {

	public final static List<ProductImage> convertToEntityList(List<ProductImageMessage> productImageMessageList) {
		if (productImageMessageList == null) {
			return null;
		}

		List<ProductImage> productImageList = new ArrayList<ProductImage>();
		for (ProductImageMessage productImageMessage : productImageMessageList) {
			productImageList.add(convertToEntity(productImageMessage));
		}

		return productImageList;
	}

	public final static List<ProductImageMessage> convertToMessageList(List<ProductImage> productImageList) {
		if (productImageList == null) {
			return null;
		}

		List<ProductImageMessage> productImageMessageList = new ArrayList<ProductImageMessage>();
		for (ProductImage productImage : productImageList) {
			productImageMessageList.add(convertToMessage(productImage));
		}

		return productImageMessageList;
	}

	public final static ProductImage convertToEntity(ProductImageMessage productImageMessage) {
		ProductImage productImage = new ProductImage();

		productImage.setProductImageId(productImageMessage.getProductImageId());
		productImage.setProductId(productImageMessage.getProductId());
		productImage.setImage(productImageMessage.getImage());
		productImage.setSortingOrder(productImageMessage.getSortingOrder());

		return productImage;
	}

	public final static ProductImageMessage convertToMessage(ProductImage productImage) {
		ProductImageMessage productImageMessage = new ProductImageMessage();

		productImageMessage.setProductImageId(productImage.getProductImageId());
		productImageMessage.setProductId(productImage.getProductId());
		productImageMessage.setImage(productImage.getImage());
		productImageMessage.setSortingOrder(productImage.getSortingOrder());

		return productImageMessage;
	}

}


