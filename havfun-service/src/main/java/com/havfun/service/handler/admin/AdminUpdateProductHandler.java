package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.product.AdminUpdateProductRequest;
import com.havfun.service.message.admin.product.AdminUpdateProductResponse;

public class AdminUpdateProductHandler extends AbstractHkListCoEventHandler<AdminUpdateProductRequest, AdminUpdateProductResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminUpdateProductHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminUpdateProductResponse handle(AdminUpdateProductRequest request)
			throws Exception {
		LOGGER.debug("handle AdminUpdateProductRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminUpdateProductResponse) context.get(RESPONSE);
	}

}
