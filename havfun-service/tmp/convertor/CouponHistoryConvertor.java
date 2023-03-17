package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.CouponHistory;
import com.havfun.service.message.data.CouponHistoryMessage;

public class CouponHistoryConvertor {

	public final static List<CouponHistory> convertToEntityList(List<CouponHistoryMessage> couponHistoryMessageList) {
		if (couponHistoryMessageList == null) {
			return null;
		}

		List<CouponHistory> couponHistoryList = new ArrayList<CouponHistory>();
		for (CouponHistoryMessage couponHistoryMessage : couponHistoryMessageList) {
			couponHistoryList.add(convertToEntity(couponHistoryMessage));
		}

		return couponHistoryList;
	}

	public final static List<CouponHistoryMessage> convertToMessageList(List<CouponHistory> couponHistoryList) {
		if (couponHistoryList == null) {
			return null;
		}

		List<CouponHistoryMessage> couponHistoryMessageList = new ArrayList<CouponHistoryMessage>();
		for (CouponHistory couponHistory : couponHistoryList) {
			couponHistoryMessageList.add(convertToMessage(couponHistory));
		}

		return couponHistoryMessageList;
	}

	public final static CouponHistory convertToEntity(CouponHistoryMessage couponHistoryMessage) {
		CouponHistory couponHistory = new CouponHistory();

		couponHistory.setCouponHistoryId(couponHistoryMessage.getCouponHistoryId());
		couponHistory.setCouponId(couponHistoryMessage.getCouponId());
		couponHistory.setOrderId(couponHistoryMessage.getOrderId());
		couponHistory.setClientId(couponHistoryMessage.getClientId());
		couponHistory.setAmount(couponHistoryMessage.getAmount());
		couponHistory.setCreateTimestamp(couponHistoryMessage.getCreateTimestamp());

		return couponHistory;
	}

	public final static CouponHistoryMessage convertToMessage(CouponHistory couponHistory) {
		CouponHistoryMessage couponHistoryMessage = new CouponHistoryMessage();

		couponHistoryMessage.setCouponHistoryId(couponHistory.getCouponHistoryId());
		couponHistoryMessage.setCouponId(couponHistory.getCouponId());
		couponHistoryMessage.setOrderId(couponHistory.getOrderId());
		couponHistoryMessage.setClientId(couponHistory.getClientId());
		couponHistoryMessage.setAmount(couponHistory.getAmount());
		couponHistoryMessage.setCreateTimestamp(couponHistory.getCreateTimestamp());

		return couponHistoryMessage;
	}

}


