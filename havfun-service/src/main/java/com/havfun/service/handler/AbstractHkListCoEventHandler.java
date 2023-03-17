package com.havfun.service.handler;

import org.apache.commons.chain.impl.ChainBase;

import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.AbstractResponse;

public abstract class AbstractHkListCoEventHandler<Q extends AbstractRequest, S extends AbstractResponse> extends ChainBase implements RequestHandler<Q, S> {

	public final static String REQUEST = "request";
	
	public final static String RESPONSE = "response";
	
	public final static String USER = "user";
}
