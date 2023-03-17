package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.productgroup.AdminUpdateProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminUpdateProductGroupResponse;

public class AdminUpdateProductGroupHandler extends AbstractHkListCoEventHandler<AdminUpdateProductGroupRequest, AdminUpdateProductGroupResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateProductGroupHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateProductGroupResponse handle(AdminUpdateProductGroupRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateProductGroupRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateProductGroupResponse) context.get(RESPONSE);
	}

}
