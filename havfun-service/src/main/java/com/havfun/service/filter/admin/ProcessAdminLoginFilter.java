package com.havfun.service.filter.admin;

import java.util.List;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.UserConvertor;
import com.havfun.service.dao.UserDao;
import com.havfun.service.dao.UserLoginHistoryDao;
import com.havfun.service.entity.User;
import com.havfun.service.entity.UserLoginHistory;
import com.havfun.service.entity.constant.LoginStatus;
import com.havfun.service.entity.constant.UserStatus;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminLoginRequest;
import com.havfun.service.message.admin.AdminLoginResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminLoginFilter implements Filter {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminLoginFilter.class.getSimpleName());
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserLoginHistoryDao userLoginHistoryDao;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminLoginRequest request = (AdminLoginRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		String userLoginId = request.getUserLoginId();
		String passcode = request.getPasscode();
		String ipAddress = request.getIpAddress();
		
		if (userLoginId == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "userLoginId is null");
		}
		
		if (passcode == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "passcode is null");
		}
		
		if (ipAddress == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "ipAddress is null");
		}
		
		LOGGER.info("userLoginId: {}, passcode: {}, ipAddress: {}", userLoginId, passcode, ipAddress);
		
		boolean failToLogin = false;
		
		User user = userDao.readByUserName(userLoginId);
		
		if (user == null) {
			throw new HavfunException(ErrorCode.LOGIN_USER_NOT_FOUND, "user not found");
		}
		
		if (user.getStatus() != UserStatus.ACTIVE) {
			failToLogin = true;
		}

		
		if (!passcode.equals(user.getPasscode())) {
			failToLogin = true;
		}
		
		LOGGER.info("get userPasscode: {}", passcode);
		
		if (!failToLogin) {
			List<UserLoginHistory> existingUserLoginHistoryList = userLoginHistoryDao.readAllLogin(user.getUserId());
			
			if (existingUserLoginHistoryList != null) {
				for (UserLoginHistory userLoginHistory : existingUserLoginHistoryList) {
					userLoginHistory.setLoginStatus(LoginStatus.LOGOUT);
					userLoginHistory.setLoginTimestamp(System.currentTimeMillis());
					
					int result = userLoginHistoryDao.update(userLoginHistory);
					
					if (result <= 0) {
						throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update login history");
					}
				}
			}
			
			String token = generateToken(userLoginId, ipAddress);
			
			UserLoginHistory userLoginHistory = new UserLoginHistory();
			
			userLoginHistory.setUserId(user.getUserId());
			userLoginHistory.setLoginToken(token);
			userLoginHistory.setIpAddress(ipAddress);
			userLoginHistory.setLoginTimestamp(System.currentTimeMillis());
			userLoginHistory.setLoginStatus(LoginStatus.LOGIN);
			
			LOGGER.info("create userLoginHistory: {}", userLoginHistory);
			Integer userLoginHistoryId = userLoginHistoryDao.create(userLoginHistory);
			
			if (userLoginHistoryId == null) {
				throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create login history");
			}
						
			
			AdminLoginResponse response = new AdminLoginResponse();
			
			response.setResult(ErrorCode.NO_ERROR);
			response.setUserMessage(UserConvertor.convertToMessage(user));

			response.setToken(token);
			
			context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		} else {
			UserLoginHistory userLoginHistory = new UserLoginHistory();
			
			userLoginHistory.setUserId(user.getUserId());
			userLoginHistory.setLoginToken("");
			userLoginHistory.setIpAddress(ipAddress);
			userLoginHistory.setLoginTimestamp(System.currentTimeMillis());
			userLoginHistory.setLoginStatus(LoginStatus.FAIL);
			
			LOGGER.info("create userLoginHistory: {}", userLoginHistory);
			Integer userLoginHistoryId = userLoginHistoryDao.create(userLoginHistory);
			
			if (userLoginHistoryId == null) {
				throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create login history");
			}
			
			
			AdminLoginResponse response = new AdminLoginResponse();
			
			response.setResult(ErrorCode.FAIL_TO_LOGIN);
			
			context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean postprocess(Context context, Exception exception) {
		LOGGER.debug("postprocess...");
		LOGGER.debug("exception = {}", exception);
		
		if (exception != null) {
			AdminLoginResponse response = new AdminLoginResponse();
			response.setResult(ErrorCode.FAIL_TO_PROCESS);
			context.put(AbstractHkListCoEventHandler.RESPONSE, response);
			
			return true;
		}
		return false;
	}
	
	private static String generateToken(String userLoginId, String ipAddress) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(ipAddress);
		builder.append("|");
		builder.append(userLoginId);
		builder.append("|");
		builder.append(System.currentTimeMillis());
		
		return new String(new Base64().encode(builder.toString().getBytes()));
	}
	
}
