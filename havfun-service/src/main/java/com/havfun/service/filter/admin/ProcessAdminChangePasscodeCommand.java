package com.havfun.service.filter.admin;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.entity.User;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminChangePasscodeRequest;
import com.havfun.service.message.admin.AdminChangePasscodeResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminChangePasscodeCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminChangePasscodeCommand.class.getSimpleName());
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminChangePasscodeRequest request = (AdminChangePasscodeRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		String oldEncyptedPasscode = request.getOldEncryptedPasscode();
		
		String newEncyptedPasscode = request.getNewEncryptedPasscode();
		
		LOGGER.info("oldEncyptedPasscode: {}, newEncyptedPasscode: {}", oldEncyptedPasscode, newEncyptedPasscode);
		
		User user = (User) context.get(AbstractHkListCoEventHandler.USER);
		
		if (user == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "user is null");
		}
		/*
		User user = userDao.read(user.getUserId());
		
		if (!userPasscode.getPasscode().equals(oldEncyptedPasscode)) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "current passcode is not matched");
		}
		
		userPasscode.setPasscode(newEncyptedPasscode);
		userPasscode.setPasscodeChangeNextLogin("0");
		userPasscode.setPasscodeChangeTimestamp(System.currentTimeMillis());
		
		LOGGER.info("update userPasscode: {}", userPasscode);
		int result = userPasscodeDao.update(userPasscode);
		
		if (result <= 0) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update userPasscode");
		}
		*/
		AdminChangePasscodeResponse response = new AdminChangePasscodeResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
