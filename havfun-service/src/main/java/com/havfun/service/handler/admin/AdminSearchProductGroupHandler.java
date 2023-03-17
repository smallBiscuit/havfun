package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;


public class AdminSearchProductGroupHandler extends AbstractHkListCoEventHandler<AdminSearchProductGroupRequest, AdminSearchProductGroupResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchProductGroupHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchProductGroupResponse handle(AdminSearchProductGroupRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchProductGroupRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchProductGroupResponse) context.get(RESPONSE);
	}

}
