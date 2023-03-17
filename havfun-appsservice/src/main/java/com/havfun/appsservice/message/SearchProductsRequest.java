package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class SearchProductsRequest extends AbstractRequest{

	private int groupId;
	
	private String tag;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "SearchProductsRequest [groupId=" + groupId + ", tag=" + tag + ", clientId=" + clientId + ", token="
				+ token + ", messageId=" + messageId + "]";
	}


	

}
