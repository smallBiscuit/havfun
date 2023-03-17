package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.material.AdminUpdateMaterialRequest;
import com.havfun.service.message.admin.material.AdminUpdateMaterialResponse;

public class AdminUpdateMaterialHandler extends AbstractHkListCoEventHandler<AdminUpdateMaterialRequest, AdminUpdateMaterialResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateMaterialHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateMaterialResponse handle(AdminUpdateMaterialRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateMaterialRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateMaterialResponse) context.get(RESPONSE);
	}

}
