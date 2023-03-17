package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.SearchOrderRequest;
import com.havfun.service.message.SearchOrderResponse;

public class SearchOrderHandler extends AbstractHkListCoEventHandler<SearchOrderRequest, SearchOrderResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(SearchOrderHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public SearchOrderResponse handle(SearchOrderRequest request)
			throws Exception {
		LOGGER.debug("handle SearchOrderRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (SearchOrderResponse) context.get(RESPONSE);
	}

}
