package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialGroupMessage;

public class AdminUpdateMaterialGroupRequest extends BaseAdminRequest{
	
	private MaterialGroupMessage clientMessage;
	
	public AdminUpdateMaterialGroupRequest() {
		setMessageId(MessageId.ADMIN_UPDATE_MATERIAL_GROUP_REQUEST);
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
		builder.append("AdminUpdateMaterialGroupRequest [clientMessage=");
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
