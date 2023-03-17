package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.material.AdminSearchMaterialRequest;
import com.havfun.service.message.admin.material.AdminSearchMaterialResponse;


public class AdminSearchMaterialHandler extends AbstractHkListCoEventHandler<AdminSearchMaterialRequest, AdminSearchMaterialResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchMaterialHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchMaterialResponse handle(AdminSearchMaterialRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchMaterialRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchMaterialResponse) context.get(RESPONSE);
	}

}
