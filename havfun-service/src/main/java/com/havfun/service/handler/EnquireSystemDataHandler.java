package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireSystemDataRequest;
import com.havfun.service.message.EnquireSystemDataResponse;

public class EnquireSystemDataHandler extends AbstractHkListCoEventHandler<EnquireSystemDataRequest, EnquireSystemDataResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(EnquireSystemDataHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public EnquireSystemDataResponse handle(EnquireSystemDataRequest request)
			throws Exception {
		LOGGER.debug("handle EnquireSystemDataRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (EnquireSystemDataResponse) context.get(RESPONSE);
	}

}
