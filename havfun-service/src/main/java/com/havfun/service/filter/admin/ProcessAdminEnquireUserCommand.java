package com.havfun.service.filter.admin;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.UserConvertor;
import com.havfun.service.dao.UserDao;
import com.havfun.service.entity.User;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.user.AdminEnquireUserRequest;
import com.havfun.service.message.admin.user.AdminEnquireUserResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.UserMessage;

public class ProcessAdminEnquireUserCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminEnquireUserCommand.class.getSimpleName());
	
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminEnquireUserRequest request = (AdminEnquireUserRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int userId = request.getUserId();
		
		LOGGER.info("userId: {}", userId);
		
		User user = userDao.read(userId);
		
		if (user == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot read user");
		}
		
		UserMessage userMessage = UserConvertor.convertToMessage(user);
		
		AdminEnquireUserResponse response = new AdminEnquireUserResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setUserMessage(userMessage);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
