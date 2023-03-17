package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminChangePasscodeRequest;
import com.havfun.service.message.admin.AdminChangePasscodeResponse;

public class AdminChangePasscodeHandler extends AbstractHkListCoEventHandler<AdminChangePasscodeRequest, AdminChangePasscodeResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminChangePasscodeHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminChangePasscodeResponse handle(AdminChangePasscodeRequest request)
			throws Exception {
		LOGGER.debug("handle AdminChangePasswordRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminChangePasscodeResponse) context.get(RESPONSE);
	}

}
