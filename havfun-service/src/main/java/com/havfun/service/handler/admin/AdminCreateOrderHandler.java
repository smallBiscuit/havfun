package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminCreateOrderRequest;
import com.havfun.service.message.admin.order.AdminCreateOrderResponse;

public class AdminCreateOrderHandler extends AbstractHkListCoEventHandler<AdminCreateOrderRequest, AdminCreateOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminCreateOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminCreateOrderResponse handle(AdminCreateOrderRequest request)
			throws Exception {
		LOGGER.debug("handle AdminCreateOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminCreateOrderResponse) context.get(RESPONSE);
	}

}
