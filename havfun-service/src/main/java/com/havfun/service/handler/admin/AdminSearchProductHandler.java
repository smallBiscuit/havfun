package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.product.AdminSearchProductRequest;
import com.havfun.service.message.admin.product.AdminSearchProductResponse;


public class AdminSearchProductHandler extends AbstractHkListCoEventHandler<AdminSearchProductRequest, AdminSearchProductResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchProductHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchProductResponse handle(AdminSearchProductRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchProductRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchProductResponse) context.get(RESPONSE);
	}

}
