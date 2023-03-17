package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminLoginRequest;
import com.havfun.service.message.admin.AdminLoginResponse;


public class AdminLoginHandler extends AbstractHkListCoEventHandler<AdminLoginRequest, AdminLoginResponse> {
	
	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminLoginHandler.class.getSimpleName());

	@SuppressWarnings("unchecked")
	@Override
	public AdminLoginResponse handle(AdminLoginRequest request)
			throws Exception {
		LOGGER.debug("handle AdminLoginRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminLoginResponse) context.get(RESPONSE);
	}

}
