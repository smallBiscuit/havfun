package com.havfun.service.message.admin.material;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;

public class AdminUpdateMaterialResponse extends AbstractResponse {
	
	public AdminUpdateMaterialResponse() {
		setMessageId(MessageId.ADMIN_UPDATE_MATERIAL_RESPONSE);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateMaterialResponse [result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
