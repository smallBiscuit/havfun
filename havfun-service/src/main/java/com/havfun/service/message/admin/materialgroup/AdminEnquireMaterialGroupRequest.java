package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireMaterialGroupRequest extends BaseAdminRequest {
	
	private int clientId;
	
	public AdminEnquireMaterialGroupRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_MATERIAL_GROUP_REQUEST);
	}

	public int getMaterialGroupId() {
		return clientId;
	}

	public void setMaterialGroupId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireMaterialGroupRequest [clientId=");
		builder.append(clientId);
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
