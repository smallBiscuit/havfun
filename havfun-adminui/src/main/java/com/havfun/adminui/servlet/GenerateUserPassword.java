package com.havfun.adminui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.AdminGeneratePasscodeRequest;
import com.havfun.service.message.admin.AdminGeneratePasscodeResponse;
import com.havfun.adminui.helper.AuthHelper;
import com.havfun.adminui.helper.ClientServiceHelper;


/**
 * Servlet implementation class SearchAEClient
 */
@WebServlet("/GenerateUserPassword")
public class GenerateUserPassword extends AbstractServlet {
	private static Logger LOGGER = LogManager.getLogger(GenerateUserPassword.class.getName());	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateUserPassword() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		String userId = (String)request.getParameter("userId");
		String generatedToken = (String)request.getParameter("generatedToken");
		
		int result = 0;
		
		AdminGeneratePasscodeRequest generatePasswordRequest = new AdminGeneratePasscodeRequest();		
		try{
			generatePasswordRequest.setUserId( Integer.parseInt( userId) );
		}catch (Exception e){
			LOGGER.warn("GenerateClientPassword process Excpetion"+ e.getMessage() );
		}
		generatePasswordRequest.setGeneratedToken( generatedToken );
		
		//Check if clientId match with clientEmail
		String randomString = RandomStringUtils.random(8, true, true);
		LOGGER.info("GenPassword: process: randomString "+ randomString);
		
		String encryptedGeneratedPassword = AuthHelper.getSha256String(randomString);
		generatePasswordRequest.setEncyptedGeneratedPasscode(encryptedGeneratedPassword);
		generatePasswordRequest.setPasscode(randomString);
		
		LOGGER.info("GenerateClientPassword process generatePasswordRequest "+ generatePasswordRequest);
		AdminGeneratePasscodeResponse generatePasswordResponse = ClientServiceHelper.getInstance().getClientService().invoke( generatePasswordRequest );
		LOGGER.info("GenerateClientPassword process generatePasswordResponse "+ generatePasswordResponse);
		
		if ( generatePasswordResponse != null ){
			result = generatePasswordResponse.getResult();
		}else{
			result = -999;
		}
		
		request.removeAttribute("ActionMap");
		request.setAttribute("result", result);
		request.getRequestDispatcher("/WEB-INF/generateUserPassword.jsp").forward(request,
				response);			
	}
	
	 @Override
	protected boolean isAuthenticationRequired() {
		return false;
	}
	
}