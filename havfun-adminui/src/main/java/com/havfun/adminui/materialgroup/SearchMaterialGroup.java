package com.havfun.adminui.materialgroup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class SearchMaterialGroup
 */
@WebServlet("/SearchMaterialGroup")
public class SearchMaterialGroup extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchMaterialGroup.class.getName());
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMaterialGroup() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result = ErrorCode.NO_ERROR;
		BaseUser baseUser = (BaseUser)request.getAttribute( LOGON_USER );
		

		AdminSearchMaterialGroupRequest searchRequest = new AdminSearchMaterialGroupRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchMaterialGroup:: process:: searchRequest:: "+ searchRequest );
		AdminSearchMaterialGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchMaterialGroup:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null ){

			result = searchResponse.getResult();
			
		}else{
		
			result = ErrorCode.INTERNAL_ERROR;
			
		}
			
			
		if ( result == ErrorCode.NO_ERROR ){
			
			request.setAttribute("materialGroupList", searchResponse.getMaterialGroupMessageList() );				
			request.setAttribute(MaterialGroupHelper.NAVIGATOR, "content_material_group_search_material_group");
			
		}else{

			response.sendRedirect("Error?ErrMsg=Could not connect server");
			
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/searchMaterialGroup.jsp").forward(request, response);

	}
	
}