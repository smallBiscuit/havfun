package com.havfun.adminui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Error
 */
@WebServlet("/Error")
public class Error extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Error() {
        super();
    }
    
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);		
	}
	
	@Override
	protected boolean isAuthorizationRequired() {
		return false;
	}



}

