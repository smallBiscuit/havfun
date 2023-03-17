package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ProductDiscount;
import com.havfun.service.message.data.ProductDiscountMessage;

public class ProductDiscountConvertor {

	public final static List<ProductDiscount> convertToEntityList(List<ProductDiscountMessage> productDiscountMessageList) {
		if (productDiscountMessageList == null) {
			return null;
		}

		List<ProductDiscount> productDiscountList = new ArrayList<ProductDiscount>();
		for (ProductDiscountMessage productDiscountMessage : productDiscountMessageList) {
			productDiscountList.add(convertToEntity(productDiscountMessage));
		}

		return productDiscountList;
	}

	public final static List<ProductDiscountMessage> convertToMessageList(List<ProductDiscount> productDiscountList) {
		if (productDiscountList == null) {
			return null;
		}

		List<ProductDiscountMessage> productDiscountMessageList = new ArrayList<ProductDiscountMessage>();
		for (ProductDiscount productDiscount : productDiscountList) {
			productDiscountMessageList.add(convertToMessage(productDiscount));
		}

		return productDiscountMessageList;
	}

	public final static ProductDiscount convertToEntity(ProductDiscountMessage productDiscountMessage) {
		ProductDiscount productDiscount = new ProductDiscount();

		productDiscount.setProductDiscountId(productDiscountMessage.getProductDiscountId());
		productDiscount.setProductId(productDiscountMessage.getProductId());
		productDiscount.setClientGroup(productDiscountMessage.getClientGroup());
		productDiscount.setQuantity(productDiscountMessage.getQuantity());
		productDiscount.setPriority(productDiscountMessage.getPriority());
		productDiscount.setPrice(productDiscountMessage.getPrice());
		productDiscount.setStartDate(productDiscountMessage.getStartDate());
		productDiscount.setEndDate(productDiscountMessage.getEndDate());

		return productDiscount;
	}

	public final static ProductDiscountMessage convertToMessage(ProductDiscount productDiscount) {
		ProductDiscountMessage productDiscountMessage = new ProductDiscountMessage();

		productDiscountMessage.setProductDiscountId(productDiscount.getProductDiscountId());
		productDiscountMessage.setProductId(productDiscount.getProductId());
		productDiscountMessage.setClientGroup(productDiscount.getClientGroup());
		productDiscountMessage.setQuantity(productDiscount.getQuantity());
		productDiscountMessage.setPriority(productDiscount.getPriority());
		productDiscountMessage.setPrice(productDiscount.getPrice());
		productDiscountMessage.setStartDate(productDiscount.getStartDate());
		productDiscountMessage.setEndDate(productDiscount.getEndDate());

		return productDiscountMessage;
	}

}


