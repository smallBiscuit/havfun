package com.havfun.service.filter.admin;

import java.util.List;

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
import com.havfun.service.message.admin.user.AdminSearchUserRequest;
import com.havfun.service.message.admin.user.AdminSearchUserResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminSearchUserCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminSearchUserCommand.class.getSimpleName());
	
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminSearchUserRequest request = (AdminSearchUserRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<User> userList = userDao.readAll();
		
		if (userList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "userList is null");
		}
		
		LOGGER.info("userList : {}", userList);
		
		AdminSearchUserResponse response = new AdminSearchUserResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setUserMessageList(UserConvertor.convertToMessageList(userList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
