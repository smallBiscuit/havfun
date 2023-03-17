package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.user.AdminUpdateUserRequest;
import com.havfun.service.message.admin.user.AdminUpdateUserResponse;

public class AdminUpdateUserHandler extends AbstractHkListCoEventHandler<AdminUpdateUserRequest, AdminUpdateUserResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateUserHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateUserResponse handle(AdminUpdateUserRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateUserRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateUserResponse) context.get(RESPONSE);
	}

}
