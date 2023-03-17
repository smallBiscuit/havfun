package com.havfun.service.filter.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.dao.UserLoginHistoryDao;
import com.havfun.service.entity.UserLoginHistory;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.ErrorCode;


public class UserTokenAuthenticationFilter implements Filter {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(UserTokenAuthenticationFilter.class.getSimpleName());
	
	private static Map<UserGroup, Map<String, Boolean>> userRolePermissionMap = new HashMap<UserGroup, Map<String, Boolean>>();
	
	private static Map<String, Boolean> allPermittedMap = new HashMap<String, Boolean>();
	
	static {
		/*
		allPermittedMap.put(AdminLogoutRequest.class.getSimpleName(), Boolean.TRUE);
		allPermittedMap.put(AdminChangePasscodeRequest.class.getSimpleName(), Boolean.TRUE);
		
		Map<String, Boolean> userManagementPermissionMap = new HashMap<String, Boolean>();
		
		userManagementPermissionMap.put(AdminCreateUserRequest.class.getSimpleName(), Boolean.TRUE);
		userManagementPermissionMap.put(AdminUpdateUserRequest.class.getSimpleName(), Boolean.TRUE);
		userManagementPermissionMap.put(AdminEnquireUserRequest.class.getSimpleName(), Boolean.TRUE);
		userManagementPermissionMap.put(AdminSearchUserRequest.class.getSimpleName(), Boolean.TRUE);
		userManagementPermissionMap.put(AdminRemoveManageCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		userManagementPermissionMap.put(AdminSearchManageCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		userManagementPermissionMap.put(AdminResetPasscodeRequest.class.getSimpleName(), Boolean.TRUE);
		
		userRolePermissionMap.put(UserRole.USER_MANAGEMENT, userManagementPermissionMap);
		
		Map<String, Boolean> companyMakerMap = new HashMap<String, Boolean>();
		
		companyMakerMap.put(AdminCreateAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		companyMakerMap.put(AdminUpdateAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		companyMakerMap.put(AdminEnquireAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		companyMakerMap.put(AdminSearchAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		companyMakerMap.put(AdminEnquireCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		companyMakerMap.put(AdminUpdateCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		//Confirm is for cancel pending status
		companyMakerMap.put(AdminConfirmCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		
		userRolePermissionMap.put(UserRole.COMPANY_MAKER, companyMakerMap);
		
		Map<String, Boolean> companyCheckerMap = new HashMap<String, Boolean>();
		
		companyCheckerMap.put(AdminSearchAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		companyCheckerMap.put(AdminEnquireAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);		
		companyCheckerMap.put(AdminConfirmAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		companyCheckerMap.put(AdminEnquireCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		companyCheckerMap.put(AdminConfirmCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		
		userRolePermissionMap.put(UserRole.COMPANY_CHECKER, companyCheckerMap);
		
		Map<String, Boolean> adminPermissionMap = new HashMap<String, Boolean>();
		
		adminPermissionMap.put(AdminCreateManageCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminRemoveManageCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminSearchManageCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminResetPasscodeRequest.class.getSimpleName(), Boolean.TRUE);

		adminPermissionMap.put(AdminSearchAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminCreateAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminUpdateAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminConfirmAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminEnquireAnnouncementRequest.class.getSimpleName(), Boolean.TRUE);		
		
		adminPermissionMap.put(AdminSearchCompanyRequest.class.getSimpleName(), Boolean.TRUE);						
		adminPermissionMap.put(AdminCreateCompanyRequest.class.getSimpleName(), Boolean.TRUE);				
		adminPermissionMap.put(AdminUpdateCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminInactivateCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminConfirmCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(AdminEnquireCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		
		userRolePermissionMap.put(UserRole.ADMIN, adminPermissionMap);
		
		
		Map<String, Boolean> ediorPermissionMap = new HashMap<String, Boolean>();
		ediorPermissionMap.put(AdminEnquireCompanyPendingRequest.class.getSimpleName(), Boolean.TRUE);
		ediorPermissionMap.put(AdminUpdateCompanyRequest.class.getSimpleName(), Boolean.TRUE);
		userRolePermissionMap.put(UserRole.COMPANY_EDITOR, ediorPermissionMap);		
		*/
	}
	
	@Autowired
	private UserLoginHistoryDao userLoginHistoryDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		BaseAdminRequest request = (BaseAdminRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int userId = request.getLoginUserId();
		String token = request.getToken();
		
		LOGGER.info("userId: {}, token: {}", userId, token);
		
		//TODO: should move to ram instead of loading db every time...
		UserLoginHistory userLoginHistory = userLoginHistoryDao.readByUserIdAndToken(userId, token);
		
		/*
		if (userLoginHistory == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "userLoginHistory is null");
		}
		
		if (!userLoginHistory.getLoginStatus().equals( LoginStatus.LOGIN )) {
			LOGGER.info("userLoginHistory: loginStatus is not I exception");
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "loginStatus is not I");
		}
		
		
		User user = userDao.read(userId);

		if (user == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "user is null");
		}
		
		Map<String, Boolean> permissionMap = userRolePermissionMap.get(user.getUserGroup());
		
		if (permissionMap == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "permissionMap is null");
		}
		
		String className = request.getClass().getSimpleName();
		if (permissionMap.get(className) == null && allPermittedMap.get(className) == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "no permission for this user role");
		}
		
		context.put(AbstractHkListCoEventHandler.USER, user);
		*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean postprocess(Context context, Exception exception) {
		if (exception != null && exception instanceof HavfunException) {
			int errorCode = ((HavfunException)exception).getErrorCode();
			BaseAdminRequest request = (BaseAdminRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
			AbstractResponse response = getCorrespondingResponse(request);
			response.setResult(errorCode);
			context.put(AbstractHkListCoEventHandler.RESPONSE, response);
			return true;
		}
		
		return false;
	}
	
	private AbstractResponse getCorrespondingResponse(BaseAdminRequest request) {
		String requestClassName = request.getClass().getName();
		LOGGER.debug("request className  = {}", requestClassName);
		
		if (requestClassName.endsWith("Request")) {
			String responseClassName = requestClassName.substring(0, requestClassName.length() - 7) + "Response";
			
			AbstractResponse response = null;
			try {
				response = (AbstractResponse) Class.forName(responseClassName).newInstance();
			} catch (InstantiationException e) {
				LOGGER.warn("InstantiationException", e);
			} catch (IllegalAccessException e) {
				LOGGER.warn("IllegalAccessException", e);
			} catch (ClassNotFoundException e) {
				LOGGER.warn("ClassNotFoundException", e);
			}
			
			return response;
		}
		return null;
		
	}

}
