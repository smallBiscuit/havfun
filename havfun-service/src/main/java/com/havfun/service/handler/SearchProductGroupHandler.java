package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;

public class SearchProductGroupHandler extends AbstractHkListCoEventHandler<SearchProductGroupRequest, SearchProductGroupResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(SearchProductGroupHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public SearchProductGroupResponse handle(SearchProductGroupRequest request)
			throws Exception {
		LOGGER.debug("handle SearchProductGroupRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (SearchProductGroupResponse) context.get(RESPONSE);
	}

}
