package com.havfun.service.data;

public class ErrorCode {

	public final static int COMMON_NO_ERROR = 0;
	
	public final static int ERROR_CODE_COMMON_DATA_INVALID = -1;
	public final static int ERROR_CODE_COMMON_UNAUTH= -2;
	public final static int ERROR_CODE_COMMON_ACTION_FAIL = -3;
	
	public final static int LOGIN_RESULT_USER_NOT_FOUND = -10001;
	public final static int LOGIN_RESULT_PASSCODE_NOT_FOUND = -10002;
	public final static int LOGIN_RESULT_PASSCODE_NOT_MATCH = -10003;

	
	public final static int REGISTER_RESULT_NAME_EXISTED = -20001;
	public final static int REGISTER_RESULT_EMAIL_EXISTED = -20002;
	

}
