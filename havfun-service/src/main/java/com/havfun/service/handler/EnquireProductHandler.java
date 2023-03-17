package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireProductRequest;
import com.havfun.service.message.EnquireProductResponse;

public class EnquireProductHandler extends AbstractHkListCoEventHandler<EnquireProductRequest, EnquireProductResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(EnquireProductHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public EnquireProductResponse handle(EnquireProductRequest request)
			throws Exception {
		LOGGER.debug("handle EnquireProductRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (EnquireProductResponse) context.get(RESPONSE);
	}

}

