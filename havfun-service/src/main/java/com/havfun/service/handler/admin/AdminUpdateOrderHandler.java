package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminUpdateOrderRequest;
import com.havfun.service.message.admin.order.AdminUpdateOrderResponse;

public class AdminUpdateOrderHandler extends AbstractHkListCoEventHandler<AdminUpdateOrderRequest, AdminUpdateOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateOrderResponse handle(AdminUpdateOrderRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateOrderResponse) context.get(RESPONSE);
	}

}
