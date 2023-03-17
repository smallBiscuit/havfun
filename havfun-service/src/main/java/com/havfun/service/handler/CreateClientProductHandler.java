package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.CreateClientProductRequest;
import com.havfun.service.message.CreateClientProductResponse;

public class CreateClientProductHandler extends AbstractHkListCoEventHandler<CreateClientProductRequest, CreateClientProductResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(CreateClientProductHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public CreateClientProductResponse handle(CreateClientProductRequest request)
			throws Exception {
		LOGGER.debug("handle CreateClientProductRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (CreateClientProductResponse) context.get(RESPONSE);
	}

}
