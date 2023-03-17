package com.havfun.adminui.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.AdminGetPasscodeRequest;
import com.havfun.service.message.admin.AdminGetPasscodeResponse;
import com.havfun.service.message.admin.AdminResetPasscodeRequest;
import com.havfun.service.message.admin.AdminResetPasscodeResponse;
import com.google.gson.Gson;
import com.havfun.adminui.helper.ClientServiceHelper;

/**
 * Servlet implementation class SearchAEClient
 */
@WebServlet("/GetPasswordRequest")
public class GetPasswordRequest extends AbstractServlet {
	private static Logger LOGGER = LogManager.getLogger(GetPasswordRequest.class.getSimpleName());	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPasswordRequest() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mode = request.getParameter("mode");
		String userIdStr = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		int result = -999;
		
		LOGGER.info("GetPassword process: mode: "+ mode);

		
		if ( mode != null ){
			if ( mode.equals("1") ){//GetPassword
				AdminGetPasscodeRequest passwordRequest = new AdminGetPasscodeRequest();			

				//Check userID /userLoginID	
				if (userIdStr.matches("[0-9]+") && userIdStr.length() > 2) {
					int userId = Integer.parseInt(userIdStr);
					passwordRequest.setUserId(userId);					
				}else{
					passwordRequest.setUserLoginId(userIdStr);					
				}
				passwordRequest.setUserEmail(userEmail);
								
				
				LOGGER.info("GetPassword: process(): AdminGetPasscodeRequest:"+ passwordRequest);  		 
				AdminGetPasscodeResponse passwordResponse = ClientServiceHelper.getInstance().getClientService().invoke(passwordRequest);	
				LOGGER.info("GetPassword: process(): AdminGetPasscodeResponse:"+ passwordResponse);  				
				
				if ( passwordResponse != null ){
					if ( passwordResponse.getResult() == 0 ){
						result = passwordResponse.getResult();
					}else{
						result = -1;//passwordResponse.getResult();
					}
				}
			}
			else if( mode.equals("2")){//ForgetPassword
				AdminResetPasscodeRequest passwordRequest = new AdminResetPasscodeRequest();			

				//Check userID /userLoginID	
				if (userIdStr.matches("[0-9]+") ) {
					int userId = Integer.parseInt(userIdStr);
					passwordRequest.setUserId(userId);
				}else{
					passwordRequest.setUserLoginId(userIdStr);					
				}
				passwordRequest.setUserEmail(userEmail);
				
				
				LOGGER.info("AdminResetPasscodeRequest: process(): ClientGetPasswordRequest:"+ passwordRequest);  		 
				AdminResetPasscodeResponse passwordResponse = ClientServiceHelper.getInstance().getClientService().invoke(passwordRequest);	
				LOGGER.info("AdminResetPasscodeRequest: process(): ClientGetPasswordResponse:"+ passwordResponse);  				
				
				if ( passwordResponse != null ){
					if ( passwordResponse.getResult() == 0 ){
						result = passwordResponse.getResult();
					}else{
						result = -1;//passwordResponse.getResult();
					}
				}
			}
		}


		
		try{
			Map<String, String>resultMap = new HashMap<String, String>();
			resultMap.put("result", String.valueOf(result));
			
			
	        String json = new Gson().toJson(resultMap);
	        LOGGER.info("GetPassword: process(): json:"+ json);  
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);   				
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}        	
		
	}
	
	@Override
	protected boolean isAuthenticationRequired() {
		return false;
	}
}