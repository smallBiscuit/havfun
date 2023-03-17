package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminResetPasscodeRequest;
import com.havfun.service.message.admin.AdminResetPasscodeResponse;

public class AdminResetPasscodeHandler extends AbstractHkListCoEventHandler<AdminResetPasscodeRequest, AdminResetPasscodeResponse> {
	
	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AbstractHkListCoEventHandler.class.getSimpleName());

	@SuppressWarnings("unchecked")
	@Override
	public AdminResetPasscodeResponse handle(AdminResetPasscodeRequest request)
			throws Exception {
		LOGGER.debug("handle AdminResetPasscodeRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
						
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminResetPasscodeResponse) context.get(RESPONSE);
	}

}
