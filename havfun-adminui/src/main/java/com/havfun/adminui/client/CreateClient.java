package com.havfun.adminui.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class CreateClient
 */
@WebServlet("/" + ClientHelper.CREATE_CLIENT) 
public class CreateClient extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClient() {
        super();
    }
 
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
		clientHelper.prepareClient(request, ClientHelper.SERVLET_TYPE_CREATE);
				
		request.getRequestDispatcher(ClientHelper.CLIENT_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuClient";
	}
	
	@Override
	protected String getSubMenu() {
		return "CreateClient";
	}
	
}