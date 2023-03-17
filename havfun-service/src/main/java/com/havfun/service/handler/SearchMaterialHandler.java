package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.SearchMaterialRequest;
import com.havfun.service.message.SearchMaterialResponse;

public class SearchMaterialHandler extends AbstractHkListCoEventHandler<SearchMaterialRequest, SearchMaterialResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(SearchMaterialHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public SearchMaterialResponse handle(SearchMaterialRequest request)
			throws Exception {
		LOGGER.debug("handle SearchMaterialRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (SearchMaterialResponse) context.get(RESPONSE);
	}

}
