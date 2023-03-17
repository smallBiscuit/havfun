package com.havfun.service.filter.admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.config.HavfunConfig;
import com.havfun.service.dao.UserDao;
import com.havfun.service.dao.UserGetPasscodeDao;
import com.havfun.service.email.EmailSender;
import com.havfun.service.entity.User;
import com.havfun.service.entity.UserGetPasscode;
import com.havfun.service.entity.constant.UserGetPasscodeStatus;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.AdminGetPasscodeRequest;
import com.havfun.service.message.admin.AdminGetPasscodeResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminGetPasscodeFilter implements Filter {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminGetPasscodeFilter.class.getSimpleName());
	
	private static final long FOUR_HOURS = 1000L * 60 * 60 * 4;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private HavfunConfig havfunConfig;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserGetPasscodeDao userGetPasscodeDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminGetPasscodeRequest request = (AdminGetPasscodeRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int userId = request.getUserId();
		String userLoginId = request.getUserLoginId();
		String email = request.getUserEmail();
		
		User user;
		
		if (userId > 0) {
			user = userDao.read(userId);
		} else if (userLoginId != null) {
			user = userDao.readByUserName(userLoginId);
		} else {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "userId/userLoginId is null");
		}
		
		if (user == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "user is null");
		} else if (!user.getEmail().equals(email)) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "email is not match");
		}
		
		userId = user.getUserId();
		
		String generatedToken = getSha256String(Long.toString(System.currentTimeMillis()) + "|" + Integer.toString(userId));
		
		if (generatedToken == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "generatedToken is null");
		}
		
		UserGetPasscode userGetPasscode = userGetPasscodeDao.read(userId);
		boolean createUserGetPasscode = false;
		
		if (userGetPasscode == null) {
			userGetPasscode = new UserGetPasscode();
			userGetPasscode.setUserId(userId);
			
			createUserGetPasscode = true;
		}
		userGetPasscode.setUserGetPasscodeStatus(UserGetPasscodeStatus.ACTIVE);
		userGetPasscode.setExpiryTime(System.currentTimeMillis() + FOUR_HOURS);
		userGetPasscode.setGeneratedToken(generatedToken);
		
		if (createUserGetPasscode) {
			Integer userGetPasscodePk = userGetPasscodeDao.create(userGetPasscode);
			if (userGetPasscodePk == null) {
				throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create userGetPasscode");
			}
		} else {
			int result = userGetPasscodeDao.update(userGetPasscode);
			if (result <= 0) {
				throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update userGetPasscode");
			}
		}
		
		String url = havfunConfig.getGeneratePasswordUrl() + "?userId=" + userId + "&generatedToken=" + generatedToken;
				
		boolean bResult = emailSender.sendMail(email, getTitle(), getContent(url, user.getUserName(), user.getUserId(), user.getUserName()));
		
		if (!bResult) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "send email fail");
		}
		
		AdminGetPasscodeResponse response = new AdminGetPasscodeResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean postprocess(Context context, Exception exception) {
		LOGGER.debug("postprocess...");
		LOGGER.debug("exception = {}", exception);
		
		if (exception != null) {
			AdminGetPasscodeResponse response = new AdminGetPasscodeResponse();
			response.setResult(ErrorCode.FAIL_TO_PROCESS);
			context.put(AbstractHkListCoEventHandler.RESPONSE, response);
			
			return true;
		}
		
		return false;
	}
	
	public String getSha256String(String string) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			byte [] hashBytes = sha256.digest(string.getBytes());
			return Base64.encodeBase64URLSafeString(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.warn("getSha256String(): NoSuchAlgorithmException...", e);
		}
		
		return null;
	}
	
	public String getTitle() {
		return "HKlistco get password";
	}
	
	public String getContent(String url, String userName, int userId, String userLoginId) {
		
		String endOfLine = "<br>";
		StringBuilder builder = new StringBuilder();
		
		builder.append("<font size=\"3\" face=\"arial\">Dear " + userName + ",");
		builder.append(endOfLine);
		builder.append(endOfLine);
		
		builder.append("Thank you for using HKlistco service.  In order to get the temporary password, please click the following URL in 4 hours.");
		builder.append(endOfLine);
		builder.append(endOfLine);
		
		builder.append("URL: ");
		builder.append("<a href=\"");
		builder.append(url);
		builder.append("\">");
		builder.append(url);
		builder.append("</a>");
		
		builder.append(endOfLine);
		builder.append(endOfLine);
		
		builder.append("User Name: ");
		builder.append(userName);
		builder.append(endOfLine);
		
		builder.append("User ID: ");
		builder.append(userId);
		builder.append(endOfLine);
		builder.append(endOfLine);
		
		builder.append("Yours sincerely,");
		builder.append(endOfLine);
		builder.append("HkListco");
		builder.append(endOfLine);
		builder.append(endOfLine);
		builder.append("</font>");
		
		builder.append("<font size=\"2\" face=\"arial\">");
		builder.append("Responsibility of the Web User");
		builder.append(endOfLine);
		builder.append("You are responsible for keeping your username and password secure. You shall be responsible for all uses via your registration and/or login, whether authorised or unauthorised by you. You agree to immediately notify us of any unauthorised use of your registration, user account or password.");
		builder.append(endOfLine);
		builder.append("</font>");
		
		return builder.toString();
	}

}
