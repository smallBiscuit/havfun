package com.havfun.service.entity;

public class Address {

	private int addressId;
	
	private int clientId;
	
	private String firstName;
	
	private String lastName;
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String postcode;
	
	private int countryId;
	
	private String countryCode;
	
	private String countryNameEn;
	
	private String countryNameHk;
	
	private String countryNameCn;
	
	private int zoneId;
	
	private String telephone;
	
	private boolean billingAddress;
	
	private boolean shippingAddress;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(boolean billingAddress) {
		this.billingAddress = billingAddress;
	}

	public boolean isShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(boolean shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", clientId=" + clientId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", postcode="
				+ postcode + ", countryId=" + countryId + ", countryCode=" + countryCode + ", countryNameEn="
				+ countryNameEn + ", countryNameHk=" + countryNameHk + ", countryNameCn=" + countryNameCn + ", zoneId="
				+ zoneId + ", telephone=" + telephone + ", billingAddress=" + billingAddress + ", shippingAddress="
				+ shippingAddress + "]";
	}

}
