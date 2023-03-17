package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.material.AdminCreateMaterialRequest;
import com.havfun.service.message.admin.material.AdminCreateMaterialResponse;

public class AdminCreateMaterialHandler extends AbstractHkListCoEventHandler<AdminCreateMaterialRequest, AdminCreateMaterialResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminCreateMaterialHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminCreateMaterialResponse handle(AdminCreateMaterialRequest request)
			throws Exception {
		LOGGER.debug("handle AdminCreateMaterialRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminCreateMaterialResponse) context.get(RESPONSE);
	}

}
