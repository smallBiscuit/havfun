package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateMaterialGroupResponse extends AbstractResponse {
	
	public AdminUpdateMaterialGroupResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_MATERIAL_GROUP_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateMaterialGroupResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
