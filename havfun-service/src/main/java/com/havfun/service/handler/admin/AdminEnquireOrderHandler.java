package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminEnquireOrderRequest;
import com.havfun.service.message.admin.order.AdminEnquireOrderResponse;

public class AdminEnquireOrderHandler extends AbstractHkListCoEventHandler<AdminEnquireOrderRequest, AdminEnquireOrderResponse>{

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminEnquireOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminEnquireOrderResponse handle(AdminEnquireOrderRequest request)
			throws Exception {
		LOGGER.debug("handle AdminEnquireOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminEnquireOrderResponse) context.get(RESPONSE);
	}

}
