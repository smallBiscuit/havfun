package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupResponse;

public class AdminEnquireMaterialGroupHandler extends AbstractHkListCoEventHandler<AdminEnquireMaterialGroupRequest, AdminEnquireMaterialGroupResponse>{

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminEnquireMaterialGroupHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminEnquireMaterialGroupResponse handle(AdminEnquireMaterialGroupRequest request)
			throws Exception {
		LOGGER.debug("handle AdminEnquireMaterialGroupRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminEnquireMaterialGroupResponse) context.get(RESPONSE);
	}

}
