package com.havfun.service.message.data;

import java.util.List;

import com.havfun.service.entity.constant.ClientStatus;

public class ClientMessage {

	private int clientId;
	
	private String firstName;
	
	private String lastName;
	
	private int birthDate;
	
	private String gender;
	
	private String email;
	
	private String telephone;
	
	private String fax;
	
	private List<AddressMessage> addressList;
	
	private int referrerClientId;
	
	private int storeId;

	private String passcode;	
	
	private boolean newsletter;

	private String clientGroup;
	
	private String ipAddress;
	
	private ClientStatus status;
	
	private String token;
	
	private long createTimestamp;

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

	public List<AddressMessage> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressMessage> addressList) {
		this.addressList = addressList;
	}

	public int getReferrerClientId() {
		return referrerClientId;
	}

	public void setReferrerClientId(int referrerClientId) {
		this.referrerClientId = referrerClientId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public String getClientGroup() {
		return clientGroup;
	}

	public void setClientGroup(String clientGroup) {
		this.clientGroup = clientGroup;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public ClientStatus getStatus() {
		return status;
	}

	public void setStatus(ClientStatus status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientMessage [clientId=");
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
		builder.append(", referrerClientId=");
		builder.append(referrerClientId);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", passcode=");
		builder.append(passcode);
		builder.append(", newsletter=");
		builder.append(newsletter);
		builder.append(", clientGroup=");
		builder.append(clientGroup);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", status=");
		builder.append(status);
		builder.append(", token=");
		builder.append(token);
		builder.append(", createTimestamp=");
		builder.append(createTimestamp);
		builder.append("]");
		return builder.toString();
	}

	
}
