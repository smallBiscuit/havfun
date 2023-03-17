package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ProductAttribute;
import com.havfun.service.message.data.ProductAttributeMessage;

public class ProductAttributeConvertor {

	public final static List<ProductAttribute> convertToEntityList(List<ProductAttributeMessage> productAttributeMessageList) {
		if (productAttributeMessageList == null) {
			return null;
		}

		List<ProductAttribute> productAttributeList = new ArrayList<ProductAttribute>();
		for (ProductAttributeMessage productAttributeMessage : productAttributeMessageList) {
			productAttributeList.add(convertToEntity(productAttributeMessage));
		}

		return productAttributeList;
	}

	public final static List<ProductAttributeMessage> convertToMessageList(List<ProductAttribute> productAttributeList) {
		if (productAttributeList == null) {
			return null;
		}

		List<ProductAttributeMessage> productAttributeMessageList = new ArrayList<ProductAttributeMessage>();
		for (ProductAttribute productAttribute : productAttributeList) {
			productAttributeMessageList.add(convertToMessage(productAttribute));
		}

		return productAttributeMessageList;
	}

	public final static ProductAttribute convertToEntity(ProductAttributeMessage productAttributeMessage) {
		ProductAttribute productAttribute = new ProductAttribute();

		productAttribute.setProductAttributeId(productAttributeMessage.getProductAttributeId());
		productAttribute.setProductId(productAttributeMessage.getProductId());
		productAttribute.setAttributeKey(productAttributeMessage.getAttributeKey());
		productAttribute.setSortOrder(productAttributeMessage.getSortOrder());

		return productAttribute;
	}

	public final static ProductAttributeMessage convertToMessage(ProductAttribute productAttribute) {
		ProductAttributeMessage productAttributeMessage = new ProductAttributeMessage();

		productAttributeMessage.setProductAttributeId(productAttribute.getProductAttributeId());
		productAttributeMessage.setProductId(productAttribute.getProductId());
		productAttributeMessage.setAttributeKey(productAttribute.getAttributeKey());
		productAttributeMessage.setSortOrder(productAttribute.getSortOrder());

		return productAttributeMessage;
	}

}


