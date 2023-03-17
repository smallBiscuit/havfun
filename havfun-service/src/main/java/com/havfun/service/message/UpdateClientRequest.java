package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class UpdateClientRequest extends AbstractRequest{
	
	private String firstName;
	
	private String lastName;
	
	private int birthDate;
	
	private String gender;
	
	private String email;
	
	private String passcode;
	
	private String newPasscode;
	
	public UpdateClientRequest() {
		setMessageId(MessageId.UPDATE_CLIENT_REQUEST);
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

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getNewPasscode() {
		return newPasscode;
	}

	public void setNewPasscode(String newPasscode) {
		this.newPasscode = newPasscode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateClientRequest [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", email=");
		builder.append(email);
		builder.append(", passcode=");
		builder.append(passcode);
		builder.append(", newPasscode=");
		builder.append(newPasscode);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}


}