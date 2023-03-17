package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireClientAddressesRequest;
import com.havfun.service.message.EnquireClientAddressesResponse;

public class EnquireClientAddressesHandler extends AbstractHkListCoEventHandler<EnquireClientAddressesRequest, EnquireClientAddressesResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(EnquireClientAddressesHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public EnquireClientAddressesResponse handle(EnquireClientAddressesRequest request)
			throws Exception {
		LOGGER.debug("handle EnquireClientAddressesRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (EnquireClientAddressesResponse) context.get(RESPONSE);
	}

}
