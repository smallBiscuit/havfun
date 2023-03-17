package com.havfun.adminui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Servlet implementation class SearchAEClient
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends AbstractServlet {
	private static Logger LOGGER = LogManager.getLogger(ChangePassword.class.getSimpleName());	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		request.removeAttribute("ActionMap");
		request.removeAttribute("Menu");
		
		request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request,
				response);
	}
}
