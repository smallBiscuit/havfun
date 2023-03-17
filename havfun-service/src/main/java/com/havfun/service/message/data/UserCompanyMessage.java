package com.havfun.service.message.data;

import com.havfun.service.message.AbstractMessage;
import com.havfun.service.message.constant.MessageId;

public class UserCompanyMessage extends AbstractMessage {
	
	private int userId;
	
	private int companyId;
	
	public UserCompanyMessage() {
		setMessageId(MessageId.USER_COMPANY_MESSAGE);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserCompanyMessage [userId=");
		builder.append(userId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
