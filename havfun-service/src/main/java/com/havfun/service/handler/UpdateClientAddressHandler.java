package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.UpdateClientAddressRequest;
import com.havfun.service.message.UpdateClientAddressResponse;

public class UpdateClientAddressHandler extends AbstractHkListCoEventHandler<UpdateClientAddressRequest, UpdateClientAddressResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(UpdateClientAddressHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public UpdateClientAddressResponse handle(UpdateClientAddressRequest request)
			throws Exception {
		LOGGER.debug("handle UpdateClientAddressRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (UpdateClientAddressResponse) context.get(RESPONSE);
	}

}
