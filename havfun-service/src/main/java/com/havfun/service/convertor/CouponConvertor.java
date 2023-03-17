package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Coupon;
import com.havfun.service.message.data.CouponMessage;

public class CouponConvertor {

	public final static List<Coupon> convertToEntityList(List<CouponMessage> couponMessageList) {
		if (couponMessageList == null) {
			return null;
		}

		List<Coupon> couponList = new ArrayList<Coupon>();
		for (CouponMessage couponMessage : couponMessageList) {
			couponList.add(convertToEntity(couponMessage));
		}

		return couponList;
	}

	public final static List<CouponMessage> convertToMessageList(List<Coupon> couponList) {
		if (couponList == null) {
			return null;
		}

		List<CouponMessage> couponMessageList = new ArrayList<CouponMessage>();
		for (Coupon coupon : couponList) {
			couponMessageList.add(convertToMessage(coupon));
		}

		return couponMessageList;
	}

	public final static Coupon convertToEntity(CouponMessage couponMessage) {
		Coupon coupon = new Coupon();

		coupon.setCouponId(couponMessage.getCouponId());
		coupon.setName(couponMessage.getName());
		coupon.setCode(couponMessage.getCode());
		coupon.setType(couponMessage.getType());
		coupon.setDiscount(couponMessage.getDiscount());
		coupon.setLogged(couponMessage.isLogged());
		coupon.setShipping(couponMessage.isShipping());
		coupon.setTotal(couponMessage.getTotal());
		coupon.setStartDate(couponMessage.getStartDate());
		coupon.setEndDate(couponMessage.getEndDate());
		coupon.setUsesTotal(couponMessage.getUsesTotal());
		coupon.setUsesClient(couponMessage.getUsesClient());
		coupon.setStatus(couponMessage.getStatus());
		coupon.setCreateTimestamp(couponMessage.getCreateTimestamp());

		return coupon;
	}

	public final static CouponMessage convertToMessage(Coupon coupon) {
		CouponMessage couponMessage = new CouponMessage();

		couponMessage.setCouponId(coupon.getCouponId());
		couponMessage.setName(coupon.getName());
		couponMessage.setCode(coupon.getCode());
		couponMessage.setType(coupon.getType());
		couponMessage.setDiscount(coupon.getDiscount());
		couponMessage.setLogged(coupon.isLogged());
		couponMessage.setShipping(coupon.isShipping());
		couponMessage.setTotal(coupon.getTotal());
		couponMessage.setStartDate(coupon.getStartDate());
		couponMessage.setEndDate(coupon.getEndDate());
		couponMessage.setUsesTotal(coupon.getUsesTotal());
		couponMessage.setUsesClient(coupon.getUsesClient());
		couponMessage.setStatus(coupon.getStatus());
		couponMessage.setCreateTimestamp(coupon.getCreateTimestamp());

		return couponMessage;
	}

}


