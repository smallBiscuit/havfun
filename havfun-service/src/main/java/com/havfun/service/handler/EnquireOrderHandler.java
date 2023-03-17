package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireOrderRequest;
import com.havfun.service.message.EnquireOrderResponse;

public class EnquireOrderHandler extends AbstractHkListCoEventHandler<EnquireOrderRequest, EnquireOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(EnquireOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public EnquireOrderResponse handle(EnquireOrderRequest request)
			throws Exception {
		LOGGER.debug("handle EnquireOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (EnquireOrderResponse) context.get(RESPONSE);
	}

}
