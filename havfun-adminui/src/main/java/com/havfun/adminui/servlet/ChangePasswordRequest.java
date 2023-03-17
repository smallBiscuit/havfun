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

import com.havfun.service.message.admin.AdminChangePasscodeRequest;
import com.havfun.service.message.admin.AdminChangePasscodeResponse;
import com.google.gson.Gson;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.AuthHelper;
import com.havfun.adminui.helper.ClientServiceHelper;


/**
 * Servlet implementation class SearchAEClient
 */
@WebServlet("/ChangePasswordRequest")
public class ChangePasswordRequest extends AbstractServlet {
	private static Logger LOGGER = LogManager.getLogger(ChangePasswordRequest.class.getSimpleName());	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordRequest() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmNewPassword = request.getParameter("confirmPassword");
		
		BaseUser baseUser = (BaseUser) request.getAttribute("logonUser");
		String hashedPassword = AuthHelper.getSha256String(oldPassword);
		String hashedNewPassword = AuthHelper.getSha256String(newPassword);		
		
		LOGGER.info("ChangePasswordRequest process: oldPassword: "+ oldPassword + " newPassword: "+ newPassword + " confirmNewPassword: "+ confirmNewPassword);
		int result = 0;		
		if ( oldPassword != null && newPassword != null && confirmNewPassword != null ){

			result = isValid( newPassword, confirmNewPassword );	
			
			if ( result == 0 ){
			
				AdminChangePasscodeRequest passwordRequest = new AdminChangePasscodeRequest();
				passwordRequest.setLoginUserId( baseUser.getId()); 
				passwordRequest.setToken(baseUser.getToken());
				
				passwordRequest.setOldEncryptedPasscode( hashedPassword);
				passwordRequest.setNewEncryptedPasscode(hashedNewPassword);		
				LOGGER.info("ChangePasswordRequest: process(): passwordRequest: "+ passwordRequest);
				AdminChangePasscodeResponse passwordResponse = ClientServiceHelper.getInstance().getClientService().invoke(passwordRequest);			
				LOGGER.info("ChangePasswordRequest: process(): passwordResponse: "+ passwordResponse);
				if ( passwordResponse != null ){
					result = passwordResponse.getResult();
				}else{
					result = -999;
				}
			}
		}
		
		
		try{
			Map<String, Object>resultMap = new HashMap<String, Object>();
			resultMap.put("result", result );						
			
	        String json = new Gson().toJson(resultMap);
	        LOGGER.info("ChangePassword: process(): json:"+ json);  
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);   				
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}        		
		
	}
	
	private int isValid( String newPassword, String confirmNewPassword ){
		int result = 0 ;
		
		if ( newPassword == confirmNewPassword ){
			result = -1;
		}else if ( newPassword.length() < 8 ){
			result = -2;
		}
		
		return result;
	}
	
	@Override
	protected boolean isMainPage() {
		return false;
	}
	
}
