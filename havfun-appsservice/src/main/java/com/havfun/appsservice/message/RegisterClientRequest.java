package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class RegisterClientRequest extends AbstractRequest {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String passcode;
	
	private int birthDate;
	
	private String gender;	
	
	private String socialSignInProvider;

	private String socialSignInIdentifier;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getSocialSignInProvider() {
		return socialSignInProvider;
	}

	public void setSocialSignInProvider(String socialSignInProvider) {
		this.socialSignInProvider = socialSignInProvider;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSocialSignInIdentifier() {
		return socialSignInIdentifier;
	}

	public void setSocialSignInIdentifier(String socialSignInIdentifier) {
		this.socialSignInIdentifier = socialSignInIdentifier;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterClientRequest [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", passcode=");
		builder.append(passcode);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", socialSignInProvider=");
		builder.append(socialSignInProvider);
		builder.append(", socialSignInIdentifier=");
		builder.append(socialSignInIdentifier);
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
