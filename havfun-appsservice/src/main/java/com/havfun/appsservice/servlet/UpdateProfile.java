package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Order;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.UpdateProfileRequest;
import com.havfun.appsservice.message.UpdateProfileResponse;
import com.havfun.service.message.CreateOrderResponse;
import com.havfun.service.message.UpdateClientRequest;
import com.havfun.service.message.UpdateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Servlet implementation class UpdateClient
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(UpdateProfile.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		UpdateProfileRequest updateProfileRequest = gson.fromJson(reader, UpdateProfileRequest.class);
		UpdateProfileResponse updateProfileResponse = new UpdateProfileResponse();

		int result = ErrorCode.NO_ERROR;
		BaseClient baseClient = (BaseClient)request.getAttribute( LOGON_CLIENT );
		
		
		UpdateClientRequest updateRequest = new UpdateClientRequest();
		
		updateRequest.setClientId( baseClient.getClientId() );
		updateRequest.setToken( baseClient.getToken() );
		
		updateRequest.setFirstName( updateProfileRequest.getFirstName() );
		
		updateRequest.setLastName( updateProfileRequest.getLastName() );

		updateRequest.setBirthDate( updateProfileRequest.getBirthDate() );

		updateRequest.setGender( updateProfileRequest.getGender() );

		updateRequest.setEmail( updateProfileRequest.getEmail() );

		String encryPassword = authHelper.getSha256String( updateProfileRequest.getPasscode() );
		
		updateRequest.setPasscode( encryPassword );
		
		if ( updateProfileRequest.getNewPasscode() != null ){
			
			String encryNewPassword = authHelper.getSha256String( updateProfileRequest.getNewPasscode() );
		
			updateRequest.setNewPasscode( encryNewPassword );
			
		}
		
		LOGGER.info("UpdateClient:: process:: updateRequest:: "+ updateRequest );
		UpdateClientResponse updateResponse = ClientServiceHelper.getInstance().getClientService().invoke( updateRequest );
		LOGGER.info("UpdateClient:: process:: updateResponse:: "+ updateResponse );
		
		if ( updateResponse != null ){
			
			result = updateResponse.getResult();
			
		}else{
			
			result = ErrorCode.INTERNAL_ERROR;
			
		}
		
		updateProfileResponse.setResult(result);
		
		String json = gson.toJson( updateProfileResponse );
		LOGGER.info("UpdateProfile json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

	
	protected boolean isAuthenticationRequired(){
		return true;
	}
	
}
