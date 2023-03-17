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
import com.havfun.appsservice.convertor.AddressConvertor;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Order;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.UpdateAddressRequest;
import com.havfun.appsservice.message.UpdateAddressResponse;
import com.havfun.service.message.CreateOrderRequest;
import com.havfun.service.message.CreateOrderResponse;
import com.havfun.service.message.UpdateClientAddressRequest;
import com.havfun.service.message.UpdateClientAddressResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.AddressMessage;

/**
 * Servlet implementation class UpdateAddress
 */
@WebServlet("/UpdateAddress")
public class UpdateAddress extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(UpdateAddress.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddress() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		int result = ErrorCode.NO_ERROR;
		Gson gson = new Gson();
		
		BufferedReader reader = request.getReader();
		UpdateAddressRequest updateAddressRequest = gson.fromJson(reader, UpdateAddressRequest.class);
		UpdateAddressResponse updateAddressResponse = new UpdateAddressResponse();

		BaseClient baseClient = (BaseClient)request.getAttribute( LOGON_CLIENT );
		
		UpdateClientAddressRequest updateRequest = new UpdateClientAddressRequest();
		updateRequest.setClientId( baseClient.getClientId() );
		updateRequest.setToken( baseClient.getToken() );
		
		AddressMessage addressMessage = AddressConvertor.convertorAddressToAddressMessage( updateAddressRequest.getAddress() );
		
		addressMessage.setClientId( baseClient.getClientId() );
		
		updateRequest.setAddressMessage(addressMessage);
		
		
		LOGGER.info("Checkout:: process:: updateRequest:: "+ updateRequest );
		UpdateClientAddressResponse updateResponse = ClientServiceHelper.getInstance().getClientService().invoke( updateRequest );
		LOGGER.info("Checkout:: process:: updateResponse:: "+ updateResponse );
		
		if ( updateResponse != null ){
			
			result = updateResponse.getResult();
			
		}else{
			
			result = ErrorCode.INTERNAL_ERROR;
			
		}
		
		updateAddressResponse.setResult(result);
		
		String json = gson.toJson( updateAddressResponse );
		LOGGER.info("UpdateAddress json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	protected boolean isAuthenticationRequired(){
		return true;
	}
}
