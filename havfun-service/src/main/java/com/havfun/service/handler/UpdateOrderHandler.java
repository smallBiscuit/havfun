package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.UpdateOrderRequest;
import com.havfun.service.message.UpdateOrderResponse;

public class UpdateOrderHandler extends AbstractHkListCoEventHandler<UpdateOrderRequest, UpdateOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(UpdateOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public UpdateOrderResponse handle(UpdateOrderRequest request)
			throws Exception {
		LOGGER.debug("handle UpdateOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (UpdateOrderResponse) context.get(RESPONSE);
	}

}
