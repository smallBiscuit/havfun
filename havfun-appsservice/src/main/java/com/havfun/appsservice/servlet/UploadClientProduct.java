package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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
import com.havfun.appsservice.message.UploadClientProductRequest;
import com.havfun.appsservice.message.UploadClientProductResponse;
import com.havfun.service.base.HavfunException;
import com.havfun.service.message.CreateClientProductRequest;
import com.havfun.service.message.CreateClientProductResponse;
import com.havfun.service.message.CreateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class UploadClientProduct
 */
@WebServlet("/UploadClientProduct")
public class UploadClientProduct extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(UploadClientProduct.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadClientProduct() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		UploadClientProductRequest uiRequest = gson.fromJson(reader, UploadClientProductRequest.class);
		UploadClientProductResponse uiResponse = new UploadClientProductResponse();

		int result = ErrorCode.NO_ERROR;
		
		LOGGER.info("UploadClientProduct uiRequest: "+ uiRequest );
		
		if ( uiRequest.getToken() == null ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "token is empty" );
			
		}
		
		if ( uiRequest.getProductBaseId() == 0 ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "product base id is invalid" );			
			
		}
		
		CreateClientProductRequest appRequest = new CreateClientProductRequest();
		
		appRequest.setProductBaseId( uiRequest.getProductBaseId() );
//		appRequest.set
		
		CreateClientProductResponse appResponse = service.invoke( appRequest );
		
		uiResponse.setResult( appResponse.getResult() );
		uiResponse.setClientProductId( appResponse.getClientProductId() );
		
		String json = gson.toJson( uiResponse );
		LOGGER.info("UploadClientProduct json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}
