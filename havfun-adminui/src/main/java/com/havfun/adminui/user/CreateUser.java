package com.havfun.adminui.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/" + UserHelper.CREATE_USER) 
public class CreateUser extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
    }
 
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
		userHelper.prepareUser(request, UserHelper.SERVLET_TYPE_CREATE);
				
		request.getRequestDispatcher(UserHelper.USER_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuUser";
	}
	
	@Override
	protected String getSubMenu() {
		return "CreateUser";
	}
	
}