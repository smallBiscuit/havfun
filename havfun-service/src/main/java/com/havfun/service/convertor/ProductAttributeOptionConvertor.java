package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ProductAttributeOption;
import com.havfun.service.message.data.ProductAttributeOptionMessage;

public class ProductAttributeOptionConvertor {

	public final static List<ProductAttributeOption> convertToEntityList(List<ProductAttributeOptionMessage> productAttributeOptionMessageList) {
		if (productAttributeOptionMessageList == null) {
			return null;
		}

		List<ProductAttributeOption> productAttributeOptionList = new ArrayList<ProductAttributeOption>();
		for (ProductAttributeOptionMessage productAttributeOptionMessage : productAttributeOptionMessageList) {
			productAttributeOptionList.add(convertToEntity(productAttributeOptionMessage));
		}

		return productAttributeOptionList;
	}

	public final static List<ProductAttributeOptionMessage> convertToMessageList(List<ProductAttributeOption> productAttributeOptionList) {
		if (productAttributeOptionList == null) {
			return null;
		}

		List<ProductAttributeOptionMessage> productAttributeOptionMessageList = new ArrayList<ProductAttributeOptionMessage>();
		for (ProductAttributeOption productAttributeOption : productAttributeOptionList) {
			productAttributeOptionMessageList.add(convertToMessage(productAttributeOption));
		}

		return productAttributeOptionMessageList;
	}

	public final static ProductAttributeOption convertToEntity(ProductAttributeOptionMessage productAttributeOptionMessage) {
		ProductAttributeOption productAttributeOption = new ProductAttributeOption();

		productAttributeOption.setOptionId(productAttributeOptionMessage.getOptionId());
		productAttributeOption.setProductAttributeId(productAttributeOptionMessage.getProductAttributeId());
		productAttributeOption.setProductAttributeKey( productAttributeOptionMessage.getProductAttributeKey() );
		productAttributeOption.setProductAttributeNameEn( productAttributeOptionMessage.getProductAttributeNameEn() );
		productAttributeOption.setProductAttributeNameHk( productAttributeOptionMessage.getProductAttributeNameHk() );
		productAttributeOption.setProductAttributeNameCn( productAttributeOptionMessage.getProductAttributeNameCn() );
		productAttributeOption.setValue(productAttributeOptionMessage.getValue());
		productAttributeOption.setName(productAttributeOptionMessage.getName());

		return productAttributeOption;
	}

	public final static ProductAttributeOptionMessage convertToMessage(ProductAttributeOption productAttributeOption) {
		ProductAttributeOptionMessage productAttributeOptionMessage = new ProductAttributeOptionMessage();

		productAttributeOptionMessage.setOptionId(productAttributeOption.getOptionId());
		productAttributeOptionMessage.setProductAttributeId(productAttributeOption.getProductAttributeId());
		productAttributeOptionMessage.setProductAttributeKey( productAttributeOption.getProductAttributeKey() );
		productAttributeOptionMessage.setProductAttributeNameEn( productAttributeOption.getProductAttributeNameEn() );
		productAttributeOptionMessage.setProductAttributeNameHk( productAttributeOption.getProductAttributeNameHk() );
		productAttributeOptionMessage.setProductAttributeNameCn( productAttributeOption.getProductAttributeNameCn() );		
		productAttributeOptionMessage.setValue(productAttributeOption.getValue());
		productAttributeOptionMessage.setName(productAttributeOption.getName());

		return productAttributeOptionMessage;
	}

}


