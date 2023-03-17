package com.havfun.service.message.data;

public class CurrencyMessage {

	private int currencyId;
	
	private String code;
	
	private String symbolLeft;
	
	private String symbolRight;
	
	private int decimalPlace;
	
	private long lastModifiedTimestamp;

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbolLeft() {
		return symbolLeft;
	}

	public void setSymbolLeft(String symbolLeft) {
		this.symbolLeft = symbolLeft;
	}

	public String getSymbolRight() {
		return symbolRight;
	}

	public void setSymbolRight(String symbolRight) {
		this.symbolRight = symbolRight;
	}

	public int getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(int decimalPlace) {
		this.decimalPlace = decimalPlace;
	}

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", code=" + code + ", symbolLeft=" + symbolLeft + ", symbolRight="
				+ symbolRight + ", decimalPlace=" + decimalPlace + ", lastModifiedTimestamp=" + lastModifiedTimestamp
				+ "]";
	}
	
	
}
