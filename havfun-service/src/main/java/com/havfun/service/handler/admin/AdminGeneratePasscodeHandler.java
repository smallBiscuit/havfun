package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminGeneratePasscodeRequest;
import com.havfun.service.message.admin.AdminGeneratePasscodeResponse;

public class AdminGeneratePasscodeHandler extends AbstractHkListCoEventHandler<AdminGeneratePasscodeRequest, AdminGeneratePasscodeResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AbstractHkListCoEventHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminGeneratePasscodeResponse handle(
			AdminGeneratePasscodeRequest request) throws Exception {
		LOGGER.debug("handle AdminGeneratePasscodeRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminGeneratePasscodeResponse) context.get(RESPONSE);
	}

}
