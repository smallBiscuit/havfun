package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.user.AdminSearchUserRequest;
import com.havfun.service.message.admin.user.AdminSearchUserResponse;


public class AdminSearchUserHandler extends AbstractHkListCoEventHandler<AdminSearchUserRequest, AdminSearchUserResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchUserHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchUserResponse handle(AdminSearchUserRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchUserRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchUserResponse) context.get(RESPONSE);
	}

}
