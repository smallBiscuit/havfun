package com.havfun.appsservice.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import com.havfun.appsservice.convertor.ClientConvertor;
import com.havfun.appsservice.convertor.ProductConvertor;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Client;
import com.havfun.appsservice.data.Product;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.LogonRequest;
import com.havfun.appsservice.message.LogonResponse;
import com.havfun.appsservice.message.RegisterClientResponse;
import com.havfun.service.base.HavfunException;
import com.havfun.service.message.EnquireProductRequest;
import com.havfun.service.message.EnquireProductResponse;
import com.havfun.service.message.LoginRequest;
import com.havfun.service.message.LoginResponse;
import com.havfun.service.message.SearchProductResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductMessage;

/**
 * Servlet implementation class Logon
 */
@WebServlet("/Logon")
public class Logon extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(Logon.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logon() {
        super();
        // TODO Auto-generated constructor stub
		
    }	
	
    @Override
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{

		int result = ErrorCode.NO_ERROR;
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		LogonRequest logonRequest = gson.fromJson(reader, LogonRequest.class);
		LogonResponse logonResponse = new LogonResponse();

		String userName = logonRequest.getUserName();
		String userPasscode = logonRequest.getUserPasscode();

		
		LoginResponse loginResponse = authHelper.doLogin(userName, userPasscode, null, null, null, request, response);
	    
		if ( loginResponse != null ){

			result = loginResponse.getResult();
			
			if ( result == ErrorCode.NO_ERROR ){
			
				Client client = ClientConvertor.convertorClientMessageToClient( loginResponse.getClient(), dataHelper );
				
				logonResponse.setClient(client);
				
			}
			
		}
		
		
		logonResponse.setResult( result );
		
		String json = gson.toJson( logonResponse );
		LOGGER.info("Logon json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}
