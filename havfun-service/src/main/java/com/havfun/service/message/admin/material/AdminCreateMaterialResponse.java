package com.havfun.service.message.admin.material;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminCreateMaterialResponse extends AbstractResponse {
	
	private int clientId;
	
	public AdminCreateMaterialResponse() {
		setMessageId(MessageId.ADMIN_CREATE_MATERIAL_RESPONSE);
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
		builder.append("AdminCreateMaterialResponse [clientId=");
		builder.append(clientId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
