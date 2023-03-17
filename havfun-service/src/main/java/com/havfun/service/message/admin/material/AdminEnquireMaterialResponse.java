package com.havfun.service.message.admin.material;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialMessage;

public class AdminEnquireMaterialResponse extends AbstractResponse {
	
	private MaterialMessage clientMessage;
	
	public AdminEnquireMaterialResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_MATERIAL_RESPONSE);
	}

	public MaterialMessage getMaterialMessage() {
		return clientMessage;
	}

	public void setMaterialMessage(MaterialMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireMaterialResponse [clientMessage=");
		builder.append(clientMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
