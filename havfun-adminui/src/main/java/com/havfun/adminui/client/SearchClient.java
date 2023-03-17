package com.havfun.adminui.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.client.AdminSearchClientRequest;
import com.havfun.service.message.admin.client.AdminSearchClientResponse;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class SearchClient
 */
@WebServlet("/SearchClient")
public class SearchClient extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchClient.class.getName());
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClient() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result = 0;
		BaseUser baseUser = (BaseUser)request.getAttribute( LOGON_USER );
		

		AdminSearchClientRequest searchRequest = new AdminSearchClientRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchClient:: process:: searchRequest:: "+ searchRequest );
		AdminSearchClientResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchClient:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null ){
			result = searchResponse.getResult();
			request.setAttribute("clientList", searchResponse.getClientMessageList() );	
			
			request.setAttribute(ClientHelper.NAVIGATOR, "content_client_search_client");
			
		}else{
			result = -999;
			/*
			int result = searchResponse != null ? searchResponse.getResult() : ErrorCode.UNHANDLED_ERR;
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			*/
			response.sendRedirect("Error?ErrMsg=Could not connect server");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/searchClient.jsp").forward(request, response);

	}
}