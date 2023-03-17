package com.havfun.appsservice.message;

import com.havfun.service.message.AbstractRequest;

public class SearchAllProductGroupsRequest extends AbstractRequest{

	@Override
	public String toString() {
		return "SearchAllProductGroupsRequest [clientId=" + clientId + ", token=" + token + "]";
	}
	
}