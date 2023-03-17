package com.havfun.service.message.admin.user;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireUserRequest extends BaseAdminRequest {
	
	private int userId;
	
	public AdminEnquireUserRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_USER_REQUEST);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireUserRequest [userId=");
		builder.append(userId);
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
