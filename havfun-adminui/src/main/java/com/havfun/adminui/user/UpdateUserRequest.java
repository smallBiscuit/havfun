package com.havfun.adminui.user;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.user.AdminUpdateUserRequest;
import com.havfun.service.message.admin.user.AdminUpdateUserResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.UserMessage;
import com.havfun.service.utils.LabelUtil;
import com.google.gson.Gson;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.helper.LocalizationHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class UpdateUserRequest
 */
@WebServlet("/" + UserHelper.UPDATE_USER_REQUEST)
public class UpdateUserRequest extends AbstractServlet {
	
	private static final Logger LOGGER = LogManager.getLogger(UpdateUserRequest.class.getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserRequest() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int result = ErrorCode.NO_ERROR;
		
		Gson gson = new Gson();		
		
		UserMessage userMessage = userHelper.getUserMessage(request);
		
		request.getSession().setAttribute( "user", gson.toJson( userMessage) );
		
		
		AdminUpdateUserRequest updateRequest = new AdminUpdateUserRequest();
		
		BaseUser baseUser = (BaseUser)request.getAttribute(LOGON_USER);
		
		updateRequest.setLoginUserId(baseUser.getId());
		updateRequest.setToken(baseUser.getToken());
		updateRequest.setUserMessage( userMessage );
		
		AdminUpdateUserResponse updateResponse = ClientServiceHelper.getInstance().getClientService().invoke(updateRequest);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String lang = (String) request.getAttribute("SelectedLang");
		ResourceBundle labels = LocalizationHelper.getResourceBundle("Result", lang);
		
		if ( updateResponse == null) {

			resultMap.put("resultCode", ErrorCode.INTERNAL_ERROR);
			resultMap.put("resultMessage", LabelUtil.getDisplayValueFromResourceBundle(labels , "error_result.-999") );
			
		} else {			
			
			resultMap.put("resultCode", updateResponse.getResult());
			resultMap.put("resultMessage", LabelUtil.getDisplayValueFromResourceBundle(labels , "error_result." + updateResponse.getResult() ) );
			resultMap.put("redirectUrl", "#" );
			
		}
		response.setCharacterEncoding("UTF-8");
		String resultJSON = new Gson().toJson(resultMap);
		response.getWriter().write(resultJSON);
        
	}

}