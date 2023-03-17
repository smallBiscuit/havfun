package com.havfun.service.message.data;

import com.havfun.service.message.AbstractMessage;
import com.havfun.service.message.constant.MessageId;

public class UserPasscodeMessage extends AbstractMessage {
	
	private int userId;
	
	private String passcode;
	
	private int passcodeFailCount;
	
	private String passcodeChangeNextLogin;
	
	private long passcodeChangeTimestamp;
	
	public UserPasscodeMessage() {
		setMessageId(MessageId.USER_PASSCODE_MESSAGE);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public int getPasscodeFailCount() {
		return passcodeFailCount;
	}

	public void setPasscodeFailCount(int passcodeFailCount) {
		this.passcodeFailCount = passcodeFailCount;
	}

	public String getPasscodeChangeNextLogin() {
		return passcodeChangeNextLogin;
	}

	public void setPasscodeChangeNextLogin(String passcodeChangeNextLogin) {
		this.passcodeChangeNextLogin = passcodeChangeNextLogin;
	}

	public long getPasscodeChangeTimestamp() {
		return passcodeChangeTimestamp;
	}

	public void setPasscodeChangeTimestamp(long passcodeChangeTimestamp) {
		this.passcodeChangeTimestamp = passcodeChangeTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserPasscodeMessage [userId=");
		builder.append(userId);
		builder.append(", passcode=");
		builder.append(passcode);
		builder.append(", passcodeFailCount=");
		builder.append(passcodeFailCount);
		builder.append(", passcodeChangeNextLogin=");
		builder.append(passcodeChangeNextLogin);
		builder.append(", passcodeChangeTimestamp=");
		builder.append(passcodeChangeTimestamp);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
