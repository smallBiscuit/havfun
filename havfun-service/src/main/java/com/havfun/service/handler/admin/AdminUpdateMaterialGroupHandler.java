package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupResponse;

public class AdminUpdateMaterialGroupHandler extends AbstractHkListCoEventHandler<AdminUpdateMaterialGroupRequest, AdminUpdateMaterialGroupResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateMaterialGroupHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateMaterialGroupResponse handle(AdminUpdateMaterialGroupRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateMaterialGroupRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateMaterialGroupResponse) context.get(RESPONSE);
	}

}
