package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class SearchMaterialRequest extends AbstractRequest{

	private int materialGroupId;
	
	public SearchMaterialRequest() {
		setMessageId(MessageId.SEARCH_MATERIAL_REQUEST);
	}

	public int getMaterialGroupId() {
		return materialGroupId;
	}

	public void setMaterialGroupId(int materialGroupId) {
		this.materialGroupId = materialGroupId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchMaterialRequest [materialGroupId=");
		builder.append(materialGroupId);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}


	
}
