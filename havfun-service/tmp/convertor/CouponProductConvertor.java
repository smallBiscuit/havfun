package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.CouponProduct;
import com.havfun.service.message.data.CouponProductMessage;

public class CouponProductConvertor {

	public final static List<CouponProduct> convertToEntityList(List<CouponProductMessage> couponProductMessageList) {
		if (couponProductMessageList == null) {
			return null;
		}

		List<CouponProduct> couponProductList = new ArrayList<CouponProduct>();
		for (CouponProductMessage couponProductMessage : couponProductMessageList) {
			couponProductList.add(convertToEntity(couponProductMessage));
		}

		return couponProductList;
	}

	public final static List<CouponProductMessage> convertToMessageList(List<CouponProduct> couponProductList) {
		if (couponProductList == null) {
			return null;
		}

		List<CouponProductMessage> couponProductMessageList = new ArrayList<CouponProductMessage>();
		for (CouponProduct couponProduct : couponProductList) {
			couponProductMessageList.add(convertToMessage(couponProduct));
		}

		return couponProductMessageList;
	}

	public final static CouponProduct convertToEntity(CouponProductMessage couponProductMessage) {
		CouponProduct couponProduct = new CouponProduct();

		couponProduct.setCouponProductId(couponProductMessage.getCouponProductId());
		couponProduct.setCouponId(couponProductMessage.getCouponId());
		couponProduct.setProductId(couponProductMessage.getProductId());

		return couponProduct;
	}

	public final static CouponProductMessage convertToMessage(CouponProduct couponProduct) {
		CouponProductMessage couponProductMessage = new CouponProductMessage();

		couponProductMessage.setCouponProductId(couponProduct.getCouponProductId());
		couponProductMessage.setCouponId(couponProduct.getCouponId());
		couponProductMessage.setProductId(couponProduct.getProductId());

		return couponProductMessage;
	}

}


