package com.havfun.adminui.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.entity.constant.UserStatus;
import com.havfun.service.message.admin.user.AdminCreateUserRequest;
import com.havfun.service.message.admin.user.AdminCreateUserResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.UserMessage;
import com.havfun.service.utils.LabelUtil;
import com.google.gson.Gson;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.helper.LocalizationHelper;
import com.havfun.adminui.servlet.AbstractServlet;
 
/**
 * Servlet implementation class CreateUserRequest
 */
@WebServlet("/" + UserHelper.CREATE_USER_REQUEST)
public class CreateUserRequest extends AbstractServlet {
	
	private static final Logger LOGGER = LogManager.getLogger(CreateUserRequest.class.getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserRequest() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int result = ErrorCode.NO_ERROR;
		
		UserMessage userMessage = userHelper.getUserMessage(request);
		userMessage.setStatus( UserStatus.ACTIVE );
		
		AdminCreateUserRequest createRequest = new AdminCreateUserRequest();		
		
		BaseUser user = (BaseUser)request.getAttribute(LOGON_USER);
		createRequest.setLoginUserId(user.getId());
		createRequest.setToken( user.getToken() );
		createRequest.setUserMessage(userMessage);
				
		LOGGER.info("CreateUserRequest process createRequest "+ createRequest);
		AdminCreateUserResponse createResponse = ClientServiceHelper.getInstance().getClientService().invoke(createRequest);		
		LOGGER.info("CreateUserRequest process createResponse "+ createResponse);

		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String lang = (String) request.getAttribute("SelectedLang");
		ResourceBundle labels = LocalizationHelper.getResourceBundle("Result", lang);
		
		if ( createResponse != null) {
			
			String redirectUrl = "#";
			String resultMessage = "";
			int resultCode = createResponse.getResult();
			
			if ( createResponse.getResult() == ErrorCode.NO_ERROR ){
				
				resultMessage = LabelUtil.getDisplayValueFromResourceBundle(labels , "common_success" );
				redirectUrl = "EnquireUser?userId=" + createResponse.getUserId();
				
			}else{
				
				resultMessage = LabelUtil.getDisplayValueFromResourceBundle(labels , "error_result." + createResponse.getResult() );
				redirectUrl = "#";
			}
			
			resultMap.put("resultCode", resultCode );
			resultMap.put("resultMessage", resultMessage );
			resultMap.put("redirectUrl", redirectUrl );
			
			
		} else {			
			
			resultMap.put("resultCode", ErrorCode.INTERNAL_ERROR);
			resultMap.put("resultMessage", LabelUtil.getDisplayValueFromResourceBundle(labels , "error_result." + ErrorCode.INTERNAL_ERROR ) );			
			
		}
		response.setCharacterEncoding("UTF-8");
		String resultJSON = new Gson().toJson(resultMap);
		response.getWriter().write(resultJSON);
				
	}
}
