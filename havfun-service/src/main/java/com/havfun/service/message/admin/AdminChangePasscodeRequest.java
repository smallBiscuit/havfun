package com.havfun.service.message.admin;

import com.havfun.service.message.constant.MessageId;

public class AdminChangePasscodeRequest extends BaseAdminRequest {
	
	private String oldEncryptedPasscode;
	
	private String newEncryptedPasscode;
	
	public AdminChangePasscodeRequest() {
		setMessageId(MessageId.ADMIN_CHANGE_PASSCODE_REQUEST);
	}

	public String getOldEncryptedPasscode() {
		return oldEncryptedPasscode;
	}

	public void setOldEncryptedPasscode(String oldEncryptedPasscode) {
		this.oldEncryptedPasscode = oldEncryptedPasscode;
	}

	public String getNewEncryptedPasscode() {
		return newEncryptedPasscode;
	}

	public void setNewEncryptedPasscode(String newEncryptedPasscode) {
		this.newEncryptedPasscode = newEncryptedPasscode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminChangePasscodeRequest [oldEncryptedPasscode=");
		builder.append(oldEncryptedPasscode);
		builder.append(", newEncryptedPasscode=");
		builder.append(newEncryptedPasscode);
		builder.append(", loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}
}
