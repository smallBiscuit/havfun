package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.client.AdminUpdateClientRequest;
import com.havfun.service.message.admin.client.AdminUpdateClientResponse;

public class AdminUpdateClientHandler extends AbstractHkListCoEventHandler<AdminUpdateClientRequest, AdminUpdateClientResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateClientHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateClientResponse handle(AdminUpdateClientRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateClientRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateClientResponse) context.get(RESPONSE);
	}

}
