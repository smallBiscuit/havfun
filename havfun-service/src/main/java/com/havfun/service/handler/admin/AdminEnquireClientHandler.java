package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.client.AdminEnquireClientRequest;
import com.havfun.service.message.admin.client.AdminEnquireClientResponse;

public class AdminEnquireClientHandler extends AbstractHkListCoEventHandler<AdminEnquireClientRequest, AdminEnquireClientResponse>{

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminEnquireClientHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminEnquireClientResponse handle(AdminEnquireClientRequest request)
			throws Exception {
		LOGGER.debug("handle AdminEnquireClientRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminEnquireClientResponse) context.get(RESPONSE);
	}

}
