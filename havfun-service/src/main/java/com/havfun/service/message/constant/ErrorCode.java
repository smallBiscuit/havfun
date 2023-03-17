package com.havfun.service.message.constant;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ErrorCode {
	
	public final static int NO_ERROR = 0;
	
	public final static int ERROR_CODE_COMMON_DATA_INVALID = -1;
	public final static int ERROR_CODE_COMMON_UNAUTH= -2;
	public final static int ERROR_CODE_COMMON_ACTION_FAIL = -3;
	public final static int FAIL_TO_PROCESS = -4;
		
	public final static int LOGIN_RESULT_USER_NOT_FOUND = -10001;
	public final static int LOGIN_RESULT_PASSCODE_NOT_FOUND = -10002;
	public final static int LOGIN_RESULT_PASSCODE_NOT_MATCH = -10003;
	public final static int FAIL_TO_LOGIN = -10004;
	public final static int LOGIN_USER_NOT_FOUND = -10005;	
	public final static int LOGIN_PASSCODE_INCORRECT = -10006;	
	public final static int LOGIN_INACTIVE_USER = -10007;
	
	public final static int REGISTER_RESULT_NAME_EXISTED = -20001;
	public final static int REGISTER_RESULT_EMAIL_EXISTED = -20002;
	
	public final static int INTERNAL_ERROR = -9999;
	
	private static final Map<Integer, String> ERR_CODE_MAP = new HashMap<Integer, String>();
	static
	{
		try
		{
			Field[] aryFld = ErrorCode.class.getDeclaredFields(); 
			for (Field aFld : aryFld)
			{
				if (aFld.getType().equals(int.class))
					ERR_CODE_MAP.put(aFld.getInt(ErrorCode.class), aFld.getName());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String getErrorCode(int iErrCd)
	{
		return ERR_CODE_MAP.get(iErrCd);
	}

}
