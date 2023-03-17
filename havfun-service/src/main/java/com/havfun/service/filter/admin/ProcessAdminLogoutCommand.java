package com.havfun.service.filter.admin;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.dao.UserLoginHistoryDao;
import com.havfun.service.entity.UserLoginHistory;
import com.havfun.service.entity.constant.LoginStatus;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminLogoutRequest;
import com.havfun.service.message.admin.AdminLogoutResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminLogoutCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminLogoutCommand.class.getSimpleName());
	
	@Autowired
	private UserLoginHistoryDao userLoginHistoryDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminLogoutRequest request = (AdminLogoutRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int userId = request.getLoginUserId();
		String token = request.getToken();
		
		UserLoginHistory userLoginHistory = userLoginHistoryDao.readByUserIdAndToken(userId, token);
		
		if (userLoginHistory == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "userLoginHistory is null");
		}
		
		LOGGER.info("userLoginHistory: {}", userLoginHistory);
		
		if (userLoginHistory.getLoginStatus() != LoginStatus.LOGIN) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "loginStatus is not LOGIN");
		}
		
		userLoginHistory.setLogoutTimestamp(System.currentTimeMillis());
		userLoginHistory.setLoginStatus(LoginStatus.LOGOUT);
		
		LOGGER.info("update userLoginHistory: {}", userLoginHistory);
		int result = userLoginHistoryDao.update(userLoginHistory);
		
		if (result <= 0) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update userLoginHistory");
		}
		
		AdminLogoutResponse response = new AdminLogoutResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
