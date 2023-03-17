package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.client.AdminCreateClientRequest;
import com.havfun.service.message.admin.client.AdminCreateClientResponse;

public class AdminCreateClientHandler extends AbstractHkListCoEventHandler<AdminCreateClientRequest, AdminCreateClientResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminCreateClientHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminCreateClientResponse handle(AdminCreateClientRequest request)
			throws Exception {
		LOGGER.debug("handle AdminCreateClientRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminCreateClientResponse) context.get(RESPONSE);
	}

}
