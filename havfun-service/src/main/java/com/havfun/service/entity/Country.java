package com.havfun.service.entity;

public class Country {

	private int countryId;
	
	private String countryCode;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;
	
	private boolean active;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameHk() {
		return nameHk;
	}

	public void setNameHk(String nameHk) {
		this.nameHk = nameHk;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryCode=" + countryCode + ", nameEn=" + nameEn + ", nameHk="
				+ nameHk + ", nameCn=" + nameCn + ", active=" + active + "]";
	}
	
}
