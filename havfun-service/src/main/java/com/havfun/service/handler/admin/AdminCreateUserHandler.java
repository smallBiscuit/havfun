package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.user.AdminCreateUserRequest;
import com.havfun.service.message.admin.user.AdminCreateUserResponse;

public class AdminCreateUserHandler extends AbstractHkListCoEventHandler<AdminCreateUserRequest, AdminCreateUserResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminCreateUserHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminCreateUserResponse handle(AdminCreateUserRequest request)
			throws Exception {
		LOGGER.debug("handle AdminCreateUserRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminCreateUserResponse) context.get(RESPONSE);
	}

}
