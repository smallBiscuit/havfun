package com.havfun.service.handler;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.LoginRequest;
import com.havfun.service.message.LoginResponse;

public class LoginHandler extends AbstractHkListCoEventHandler<LoginRequest, LoginResponse> {

	/** logger **/
	private static final Logger LOGGER = LogManager.getLogger(LoginHandler.class.getSimpleName());
			
	@SuppressWarnings("unchecked")
	@Override
	public LoginResponse handle(LoginRequest request)
			throws Exception {
		LOGGER.debug("handle LoginRequest {}", request);
		
		// create context for tasks' execution
		Context context = new ContextBase();
				
		// put request into context
		context.put(REQUEST, request);
		execute(context);
		
		return (LoginResponse) context.get(RESPONSE);
	}

}
