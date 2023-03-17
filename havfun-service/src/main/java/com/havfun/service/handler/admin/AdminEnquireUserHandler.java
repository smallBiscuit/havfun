package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.user.AdminEnquireUserRequest;
import com.havfun.service.message.admin.user.AdminEnquireUserResponse;

public class AdminEnquireUserHandler extends AbstractHkListCoEventHandler<AdminEnquireUserRequest, AdminEnquireUserResponse>{

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminEnquireUserHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminEnquireUserResponse handle(AdminEnquireUserRequest request)
			throws Exception {
		LOGGER.debug("handle AdminEnquireUserRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminEnquireUserResponse) context.get(RESPONSE);
	}

}
