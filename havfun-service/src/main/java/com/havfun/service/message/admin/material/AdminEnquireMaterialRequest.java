package com.havfun.service.message.admin.material;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminEnquireMaterialRequest extends BaseAdminRequest {
	
	private int clientId;
	
	public AdminEnquireMaterialRequest() {
		setMessageId(MessageId.ADMIN_ENQUIRE_MATERIAL_REQUEST);
	}

	public int getMaterialId() {
		return clientId;
	}

	public void setMaterialId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireMaterialRequest [clientId=");
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
