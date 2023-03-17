package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.UpdateClientRequest;
import com.havfun.service.message.UpdateClientResponse;

public class UpdateClientHandler extends AbstractHkListCoEventHandler<UpdateClientRequest, UpdateClientResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(UpdateClientHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public UpdateClientResponse handle(UpdateClientRequest request)
			throws Exception {
		LOGGER.debug("handle UpdateClientRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (UpdateClientResponse) context.get(RESPONSE);
	}

}
