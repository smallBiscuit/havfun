package com.havfun.service.handler.admin;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.product.AdminCreateProductRequest;
import com.havfun.service.message.admin.product.AdminCreateProductResponse;

public class AdminCreateProductHandler extends AbstractHkListCoEventHandler<AdminCreateProductRequest, AdminCreateProductResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(AdminCreateProductHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public AdminCreateProductResponse handle(AdminCreateProductRequest request)
			throws Exception {
		LOGGER.debug("handle AdminCreateProductRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
		
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (AdminCreateProductResponse) context.get(RESPONSE);
	}

}
