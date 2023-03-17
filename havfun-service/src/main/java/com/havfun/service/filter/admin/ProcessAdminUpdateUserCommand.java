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
import com.havfun.service.message.admin.user.AdminUpdateUserRequest;
import com.havfun.service.message.admin.user.AdminUpdateUserResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.UserMessage;

public class ProcessAdminUpdateUserCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminUpdateUserCommand.class.getSimpleName());
	
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminUpdateUserRequest request = (AdminUpdateUserRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		UserMessage userMessage = request.getUserMessage();
		
		if (userMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "userMessage is null");
		}
		
		LOGGER.info("userMessage: {}", userMessage);
		
		User user = UserConvertor.convertToEntity(userMessage);
		
		LOGGER.info("update user {}", user);
		
		int userId = userDao.update(user);
		
		if (userId == 0) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update user");
		}
		
		AdminUpdateUserResponse response = new AdminUpdateUserResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
