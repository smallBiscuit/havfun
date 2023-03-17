package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.CreateClientRequest;
import com.havfun.service.message.CreateClientResponse;

public class CreateClientHandler extends AbstractHkListCoEventHandler<CreateClientRequest, CreateClientResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(CreateClientHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public CreateClientResponse handle(CreateClientRequest request)
			throws Exception {
		LOGGER.debug("handle CreateClientRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (CreateClientResponse) context.get(RESPONSE);
	}

}

