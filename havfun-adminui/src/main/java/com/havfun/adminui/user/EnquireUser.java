package com.havfun.adminui.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.user.AdminEnquireUserRequest;
import com.havfun.service.message.admin.user.AdminEnquireUserResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.UserMessage;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class EnquireUser
 */
@WebServlet("/" + UserHelper.ENQUIRE_USER)
public class EnquireUser extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireUser.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireUser() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String userIdStr = request.getParameter("userId");
		
		int userId = -1;
		
		try{
			
			userId = Integer.parseInt( userIdStr );
			
		}catch( Exception e){
			
			LOGGER.warn("Exception ", e);
			
		}
		
		userHelper.prepareUser(request, UserHelper.SERVLET_TYPE_ENQUIRE);
		
		AdminEnquireUserRequest enquireRequest = new AdminEnquireUserRequest();
		
		BaseUser user = (BaseUser)request.getAttribute(LOGON_USER);
		
		enquireRequest.setLoginUserId(user.getId());
		enquireRequest.setToken(user.getToken());
		enquireRequest.setUserId( userId );
		
		LOGGER.info("EnquireUser:: process:: enquireRequest " + enquireRequest);
		AdminEnquireUserResponse enquireResponse = ClientServiceHelper.getInstance().getClientService().invoke(enquireRequest);
		LOGGER.info("EnquireUser:: process:: enquireResponse " + enquireResponse);
		
		int result = -1;
		
		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}
		
		if (result == 0) {
			UserMessage bosUserMessage = enquireResponse.getUserMessage();

			//userMessage = UserHelper.getUserInformationMessageFromSession(request, UserHelper.ENQUIRE_USER + "_" + userMessage.getUserId());
			
			//if (userInformationMessage != null) {
				//request.setAttribute(UserHelper.USER, userInformationMessage);
			//} else {
				request.setAttribute(UserHelper.DATA_IMAGE, bosUserMessage);
			//}
		} else {
			//show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}
		
		request.getRequestDispatcher(UserHelper.USER_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuUser";
	}
}
