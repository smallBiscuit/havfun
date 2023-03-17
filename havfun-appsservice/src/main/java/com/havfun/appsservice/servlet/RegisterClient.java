package com.havfun.appsservice.servlet;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Tasks;
import com.google.gson.Gson;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.helper.AuthHelper;
import com.havfun.appsservice.message.RegisterClientRequest;
import com.havfun.appsservice.message.RegisterClientResponse;
import com.havfun.service.base.HavfunException;
import com.havfun.service.message.CreateClientRequest;
import com.havfun.service.message.CreateClientResponse;
import com.havfun.service.message.constant.ErrorCode;

/**
 * Servlet implementation class RegisterClient
 */
@WebServlet("/RegisterClient")
public class RegisterClient extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(RegisterClient.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

	private final static String SHA_256 = "SHA-256";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterClient() {
        super();
        // TODO Auto-generated constructor stub
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();
		
		BufferedReader reader = request.getReader();
		RegisterClientRequest uiRequest = gson.fromJson(reader, RegisterClientRequest.class);
		RegisterClientResponse uiResponse = new RegisterClientResponse();
		
		LOGGER.info("RegisterClient uiRequest: " + uiRequest );

		if ( uiRequest.getToken() == null ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "token is empty" );
			
		}
		
		if ( uiRequest.getSocialSignInIdentifier() == null ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "social identifier is empty" );			
			
		}
		
		/*
		 * verification the social sign in between create if not null
		 * */
		String idToken = uiRequest.getToken();
		
		FirebaseToken decodedToken;
		try {
			decodedToken = Tasks.await(FirebaseAuth.getInstance(FirebaseApp.getInstance()).verifyIdToken(idToken));
			
			String uid = decodedToken.getUid();
			
			LOGGER.info("RegisterClient uid : " + uid );
			
			if ( !uid.equals( uiRequest.getSocialSignInIdentifier() ) ){
				
				throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "invalid client" );
				
			}
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("RegisterClient Exception : ", e );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("RegisterClient Exception : ", e );
		}

		CreateClientRequest appRequest = new CreateClientRequest();
		
		appRequest.setFirstName( uiRequest.getFirstName() );
		appRequest.setLastName( uiRequest.getLastName() );
//		appRequest.setGender( uiRequest.get );
		appRequest.setEmail( uiRequest.getEmail() );
		
		String hashedPassword = getSha256String( uiRequest.getPasscode() );
		
		appRequest.setPasscode( hashedPassword );		
		appRequest.setBirthDate( uiRequest.getBirthDate() );
		appRequest.setSocialSignInProvider( uiRequest.getSocialSignInProvider() );
		appRequest.setSocialSignInIdentifier( uiRequest.getSocialSignInIdentifier() );
		
		CreateClientResponse appResponse = service.invoke( appRequest );
		

		if ( appResponse != null  ){

			uiResponse.setResult( appResponse.getResult() );
			
			if ( appResponse.getResult()  == ErrorCode.NO_ERROR ){
				
				BaseClient client = new BaseClient();
				
				client.setClientId( appResponse.getClientId() );
				client.setEmail( uiRequest.getEmail() );
				
				tokenToClientMap.put( idToken, client );
			
			}
			
		}else{
			
			uiResponse.setResult( ErrorCode.INTERNAL_ERROR );
			
		}
		
		String json = gson.toJson( uiResponse );
		LOGGER.info("RegisterClient json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	public String getSha256String(String string) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance(SHA_256);
			byte [] hashBytes = sha256.digest(string.getBytes());
			return Base64.encodeBase64URLSafeString(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}