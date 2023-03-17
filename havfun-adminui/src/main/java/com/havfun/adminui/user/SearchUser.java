package com.havfun.adminui.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.user.AdminSearchUserRequest;
import com.havfun.service.message.admin.user.AdminSearchUserResponse;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchUser.class.getName());
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result = 0;
		BaseUser baseUser = (BaseUser)request.getAttribute( LOGON_USER );
		

		AdminSearchUserRequest searchRequest = new AdminSearchUserRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchUser:: process:: searchRequest:: "+ searchRequest );
		AdminSearchUserResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchUser:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null ){
			result = searchResponse.getResult();
			request.setAttribute("userList", searchResponse.getUserMessageList() );	
			
			request.setAttribute(UserHelper.NAVIGATOR, "content_user_search_user");
			
		}else{
			result = -999;
			/*
			int result = searchResponse != null ? searchResponse.getResult() : ErrorCode.UNHANDLED_ERR;
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			*/
			response.sendRedirect("Error?ErrMsg=Could not connect server");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/searchUser.jsp").forward(request, response);

	}
}