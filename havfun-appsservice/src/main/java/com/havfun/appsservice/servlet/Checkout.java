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
import com.havfun.appsservice.data.Client;
import com.havfun.appsservice.data.Order;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.CheckoutRequest;
import com.havfun.appsservice.message.CheckoutResponse;
import com.havfun.service.message.CreateOrderRequest;
import com.havfun.service.message.CreateOrderResponse;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(Checkout.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		CheckoutRequest checkoutRequest = gson.fromJson(reader, CheckoutRequest.class);
		CheckoutResponse checkoutResponse = new CheckoutResponse();

		int result = ErrorCode.NO_ERROR;
		BaseClient baseClient = (BaseClient)request.getAttribute( LOGON_CLIENT );
		
		CreateOrderRequest createOrderRequest = new CreateOrderRequest();
		createOrderRequest.setClientId( baseClient.getClientId() );
		createOrderRequest.setToken( baseClient.getToken() );
		
		LOGGER.info("Checkout:: process:: createOrderRequest:: "+ createOrderRequest );
		CreateOrderResponse createOrderResponse = ClientServiceHelper.getInstance().getClientService().invoke( createOrderRequest );
		LOGGER.info("Checkout:: process:: createOrderResponse:: "+ createOrderResponse );
		
		Order order = new Order();
		order.setTotal( new BigDecimal("120") );
		
		checkoutResponse.setOrder(order);
		
		String json = gson.toJson( checkoutResponse );
		LOGGER.info("Checkout json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
		
	protected boolean isAuthenticationRequired(){
		return true;
	}
	
}