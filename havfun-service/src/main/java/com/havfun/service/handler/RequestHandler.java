package com.havfun.service.handler;

import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.AbstractResponse;

public interface RequestHandler <Q extends AbstractRequest, S extends AbstractResponse> {
	
	public S handle(Q request) throws Exception;

}
