package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.client.AdminSearchClientRequest;
import com.havfun.service.message.admin.client.AdminSearchClientResponse;


public class AdminSearchClientHandler extends AbstractHkListCoEventHandler<AdminSearchClientRequest, AdminSearchClientResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchClientHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchClientResponse handle(AdminSearchClientRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchClientRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchClientResponse) context.get(RESPONSE);
	}

}
