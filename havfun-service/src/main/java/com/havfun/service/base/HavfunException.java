package com.havfun.service.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.constant.ErrorCode;

public class HavfunException extends RuntimeException {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(HavfunException.class.getSimpleName());	
	
	/** serial version Uid */
	private static final long serialVersionUID = 1L;

	/** error code */
	private int errorCode;
	
	public HavfunException(int errorCode, String message) {
		super(ErrorCode.getErrorCode(errorCode) + " : " + message);
		LOGGER.warn("HavfunException:: " + ErrorCode.getErrorCode(errorCode) + " : " + message);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

}
