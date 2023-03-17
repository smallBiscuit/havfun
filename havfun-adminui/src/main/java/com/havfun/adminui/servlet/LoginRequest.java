package com.havfun.adminui.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginRequest
 */ 
@WebServlet("/LoginRequest")
public class LoginRequest extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(LoginRequest.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String username = request.getParameter("username");
		String password = request.getParameter("password");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		LOGGER.info("LoginRequest: username: " + username + ", password: " + password);
		  
		int result = authHelper.doLogin(request, response);		
		LOGGER.info("authHelper: doLogin result: "+ result);		
		
		if (result == 0) {
			// user sendRedirect to make sure the request go through the auth filter....
			// we may need to load the lang pref from db...
			
			String ref = request.getParameter(PARAMETER_NAME_REF);
			
			if (ref == null) {
				if ( request.getAttribute("isChangePassword") != null && (boolean)request.getAttribute("isChangePassword") ){
					ref = "ChangePassword";
				}else{			
					ref = "Home";
				}
				
			} else {
				ref += "?" + getQueryStringWithoutUsernamePasswordRef(request);
			}
			
			resultMap.put( "ref", ref );
			
			
		} else {
			
			result = -33;
			
			request.getSession().setAttribute("loginResult", result);
			response.sendRedirect("Login");
		}
		
		
		resultMap.put("result", result );
		
		String json = new Gson().toJson(resultMap);
		LOGGER.info("LoginRequest: process(): json:"+ json);  
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);   	
		 
	}

	@Override
	protected boolean isAuthenticationRequired() {
		return false;
	}
	
	@Override
	protected boolean isMainPage() {
		return false;
	}


}
