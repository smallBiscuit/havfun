package com.havfun.service.entity.constant;

import java.util.HashMap;
import java.util.Map;

public enum CouponType {

	ACTIVE("A"),
	
	INACTIVE("I"),
	
	LOCK("L"),
	
	;
	
	private String value;
	
	private static Map<String, CouponType> COUPON_TYPE = new HashMap<String, CouponType>();
	
	static {
		for (CouponType couponType : CouponType.values()) {
			COUPON_TYPE.put(couponType.getValue(),
					couponType);
		}
	}
	
	private CouponType(String value) {
		this.value = value;
	}
	
	public static CouponType fromValue(String value) {
		return COUPON_TYPE.get(value);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
