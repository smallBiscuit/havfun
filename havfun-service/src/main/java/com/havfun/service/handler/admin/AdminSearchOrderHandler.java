package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminSearchOrderRequest;
import com.havfun.service.message.admin.order.AdminSearchOrderResponse;


public class AdminSearchOrderHandler extends AbstractHkListCoEventHandler<AdminSearchOrderRequest, AdminSearchOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchOrderResponse handle(AdminSearchOrderRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchOrderResponse) context.get(RESPONSE);
	}

}
