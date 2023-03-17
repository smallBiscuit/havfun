package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;


public class AdminSearchMaterialGroupHandler extends AbstractHkListCoEventHandler<AdminSearchMaterialGroupRequest, AdminSearchMaterialGroupResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminSearchMaterialGroupHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminSearchMaterialGroupResponse handle(AdminSearchMaterialGroupRequest request)
			throws Exception {
		LOGGER.debug("handle AdminSearchMaterialGroupRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
				
		return (AdminSearchMaterialGroupResponse) context.get(RESPONSE);
	}

}
