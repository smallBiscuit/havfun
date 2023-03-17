package com.havfun.adminui.productgroup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class SearchProductGroup
 */
@WebServlet("/SearchProductGroup")
public class SearchProductGroup extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchProductGroup.class.getName());
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductGroup() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result = ErrorCode.NO_ERROR;
		BaseUser baseUser = (BaseUser)request.getAttribute( LOGON_USER );
		

		AdminSearchProductGroupRequest searchRequest = new AdminSearchProductGroupRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchProductGroup:: process:: searchRequest:: "+ searchRequest );
		AdminSearchProductGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchProductGroup:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null ){

			result = searchResponse.getResult();
			
		}else{
		
			result = ErrorCode.INTERNAL_ERROR;
			
		}
			
			
		if ( result == ErrorCode.NO_ERROR ){
			
			request.setAttribute("productGroupList", searchResponse.getProductGroupMessageList() );				
			request.setAttribute(ProductGroupHelper.NAVIGATOR, "content_product_group_search_product_group");
			
		}else{

			response.sendRedirect("Error?ErrMsg=Could not connect server");
			
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/searchProductGroup.jsp").forward(request, response);

	}
	
}