package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchMaterialGroupRequest extends BaseAdminRequest {
	
	public AdminSearchMaterialGroupRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_MATERIAL_GROUP_REQUEST);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchMaterialGroupRequest [loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
