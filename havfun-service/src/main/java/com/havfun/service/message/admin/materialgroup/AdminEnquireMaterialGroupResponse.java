package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialGroupMessage;

public class AdminEnquireMaterialGroupResponse extends AbstractResponse {
	
	private MaterialGroupMessage clientMessage;
	
	public AdminEnquireMaterialGroupResponse() {
		setMessageId(MessageId.ADMIN_ENQUIRE_MATERIAL_GROUP_RESPONSE);
	}

	public MaterialGroupMessage getMaterialGroupMessage() {
		return clientMessage;
	}

	public void setMaterialGroupMessage(MaterialGroupMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminEnquireMaterialGroupResponse [clientMessage=");
		builder.append(clientMessage);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
