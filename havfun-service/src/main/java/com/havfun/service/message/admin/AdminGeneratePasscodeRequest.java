package com.havfun.service.message.admin;

import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminGeneratePasscodeRequest extends AbstractRequest {
	
	private int userId;
	
	private String generatedToken;
	
	private String passcode;
	
	private String encyptedGeneratedPasscode;
	
	public AdminGeneratePasscodeRequest() {
		setMessageId(MessageId.ADMIN_GENERATE_PASSCODE_REQUEST);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGeneratedToken() {
		return generatedToken;
	}

	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getEncyptedGeneratedPasscode() {
		return encyptedGeneratedPasscode;
	}

	public void setEncyptedGeneratedPasscode(String encyptedGeneratedPasscode) {
		this.encyptedGeneratedPasscode = encyptedGeneratedPasscode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminGeneratePasscodeRequest [userId=");
		builder.append(userId);
		builder.append(", generatedToken=");
		builder.append(generatedToken);
		builder.append(", passcode=");
		builder.append(passcode);
		builder.append(", encyptedGeneratedPasscode=");
		builder.append(encyptedGeneratedPasscode);
		builder.append("]");
		return builder.toString();
	}

}
