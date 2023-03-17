package com.havfun.appsservice.data;

import java.util.List;

public class Client {

	private String clientGroup;	
	
	private int clientId;
	
	private String firstName;
	
	private String lastName;
	
	private int birthDate;
	
	private String gender;
	
	private String email;
	
	private String telephone;
	
	private String fax;
	
	private List<Address> addressList;

	public String getClientGroup() {
		return clientGroup;
	}

	public void setClientGroup(String clientGroup) {
		this.clientGroup = clientGroup;
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

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [clientGroup=");
		builder.append(clientGroup);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", addressList=");
		builder.append(addressList);
		builder.append("]");
		return builder.toString();
	}



	
	
}
