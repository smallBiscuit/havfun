package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminLogoutRequest;
import com.havfun.service.message.admin.AdminLogoutResponse;

public class AdminLogoutHandler extends AbstractHkListCoEventHandler<AdminLogoutRequest, AdminLogoutResponse> {
	
	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminLogoutHandler.class.getSimpleName());

	@SuppressWarnings("unchecked")
	@Override
	public AdminLogoutResponse handle(AdminLogoutRequest request)
			throws Exception {
		LOGGER.debug("handle AdminLogoutRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminLogoutResponse) context.get(RESPONSE);
	}
	
	

}
