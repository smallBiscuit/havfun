package com.havfun.service.message.admin.material;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialMessage;

public class AdminUpdateMaterialRequest extends BaseAdminRequest{
	
	private MaterialMessage clientMessage;
	
	public AdminUpdateMaterialRequest() {
		setMessageId(MessageId.ADMIN_UPDATE_MATERIAL_REQUEST);
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
		builder.append("AdminUpdateMaterialRequest [clientMessage=");
		builder.append(clientMessage);
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
