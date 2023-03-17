package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum CouponStatus {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, CouponStatus> COUPON_STATUS_MAP = new HashMap<String, CouponStatus>();
	
	static {
		for (CouponStatus couponStatus : CouponStatus.values()) {
			COUPON_STATUS_MAP.put(couponStatus.getValue(),
					couponStatus);
		}
	}
	
	private CouponStatus(String value) {
		this.value = value;
	}
	
	public static CouponStatus fromValue(String value) {
		return COUPON_STATUS_MAP.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
