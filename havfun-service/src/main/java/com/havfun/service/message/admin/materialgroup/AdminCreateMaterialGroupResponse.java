package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateMaterialGroupResponse extends AbstractResponse {
	
	private int clientId;
	
	public AdminCreateMaterialGroupResponse() {
		setMessageId(MessageId.ADMIN_CREATE_MATERIAL_GROUP_RESPONSE);
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
		builder.append("AdminCreateMaterialGroupResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
