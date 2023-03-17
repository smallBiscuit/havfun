package com.havfun.adminui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutRequest
 */
@WebServlet("/Logout")
public class Logout extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
    }
 
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		authHelper.doLogout(request, response);
		
		response.sendRedirect("Login");
		
	}


}
