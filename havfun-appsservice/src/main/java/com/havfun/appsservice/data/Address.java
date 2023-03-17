package com.havfun.appsservice.data;

public class Address {

	private int addressId;
	
	private String firstName;
	
	private String lastName;
	
	private String address1;
	
	private String address2;
	
	private int countryId;
	
	private String countryCode;
	
	private String countryNameEn;
	
	private String countryNameHk;
	
	private String countryNameCn;
	
	private String city;
	
	private String postcode;
	
	private String phoneNumber;
	
	private boolean isBillingAddress;
	
	private boolean isShippingAddress;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

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

	public String getCountryNameEn() {
		return countryNameEn;
	}

	public void setCountryNameEn(String countryNameEn) {
		this.countryNameEn = countryNameEn;
	}

	public String getCountryNameHk() {
		return countryNameHk;
	}

	public void setCountryNameHk(String countryNameHk) {
		this.countryNameHk = countryNameHk;
	}

	public String getCountryNameCn() {
		return countryNameCn;
	}

	public void setCountryNameCn(String countryNameCn) {
		this.countryNameCn = countryNameCn;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isBillingAddress() {
		return isBillingAddress;
	}

	public void setBillingAddress(boolean isBillingAddress) {
		this.isBillingAddress = isBillingAddress;
	}

	public boolean isShippingAddress() {
		return isShippingAddress;
	}

	public void setShippingAddress(boolean isShippingAddress) {
		this.isShippingAddress = isShippingAddress;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", firstName=" + firstName + ", lastName=" + lastName + ", address1="
				+ address1 + ", address2=" + address2 + ", countryId=" + countryId + ", countryCode=" + countryCode
				+ ", countryNameEn=" + countryNameEn + ", countryNameHk=" + countryNameHk + ", countryNameCn="
				+ countryNameCn + ", city=" + city + ", postcode=" + postcode + ", phoneNumber=" + phoneNumber
				+ ", isBillingAddress=" + isBillingAddress + ", isShippingAddress=" + isShippingAddress + "]";
	}


}
