package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.CreateOrderRequest;
import com.havfun.service.message.CreateOrderResponse;

public class CreateOrderHandler extends AbstractHkListCoEventHandler<CreateOrderRequest, CreateOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(CreateOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public CreateOrderResponse handle(CreateOrderRequest request)
			throws Exception {
		LOGGER.debug("handle CreateOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (CreateOrderResponse) context.get(RESPONSE);
	}

}
