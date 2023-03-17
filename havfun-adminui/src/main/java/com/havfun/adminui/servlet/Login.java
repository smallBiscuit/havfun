package com.havfun.adminui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(Login.class.getName());
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
	public Login() {
        super();
    }
	
	
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected boolean isAuthenticationRequired() {
		return false;
	}
}
