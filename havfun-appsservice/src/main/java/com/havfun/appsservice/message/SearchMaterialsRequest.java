package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class SearchMaterialsRequest extends AbstractRequest{

	private int groupId;
	
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchMaterialsRequest [groupId=");
		builder.append(groupId);
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
