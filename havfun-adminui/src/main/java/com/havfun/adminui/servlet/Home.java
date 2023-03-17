package com.havfun.adminui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Home")
public class Home extends AbstractServlet{
	private static final long serialVersionUID = 1L;
    
	private static Logger LOGGER = LogManager.getLogger(Home.class.getSimpleName());		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }
    	
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		SearchProductGroupRequest searchRequest = new SearchProductGroupRequest();
		
		LOGGER.info("SearchProductGroup:: process:: searchRequest: "+ searchRequest );
		SearchProductGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchProductGroup:: process:: searchResponse: "+ searchResponse );
		
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);		
		
	}

}
