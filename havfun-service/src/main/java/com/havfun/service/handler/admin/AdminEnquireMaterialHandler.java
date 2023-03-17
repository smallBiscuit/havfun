package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.material.AdminEnquireMaterialRequest;
import com.havfun.service.message.admin.material.AdminEnquireMaterialResponse;

public class AdminEnquireMaterialHandler extends AbstractHkListCoEventHandler<AdminEnquireMaterialRequest, AdminEnquireMaterialResponse>{

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminEnquireMaterialHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminEnquireMaterialResponse handle(AdminEnquireMaterialRequest request)
			throws Exception {
		LOGGER.debug("handle AdminEnquireMaterialRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminEnquireMaterialResponse) context.get(RESPONSE);
	}

}
