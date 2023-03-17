package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.SearchProductRequest;
import com.havfun.service.message.SearchProductResponse;

public class SearchProductHandler extends AbstractHkListCoEventHandler<SearchProductRequest, SearchProductResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(SearchProductHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public SearchProductResponse handle(SearchProductRequest request)
			throws Exception {
		LOGGER.debug("handle SearchProductRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (SearchProductResponse) context.get(RESPONSE);
	}

}
