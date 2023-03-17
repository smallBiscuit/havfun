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
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Order;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.UpdateOrderRequest;
import com.havfun.appsservice.message.UpdateOrderResponse;
import com.havfun.service.entity.constant.OrderStatus;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;

/**
 * Servlet implementation class UpdateOrder
 */
@WebServlet("/UpdateOrder")
public class UpdateOrder extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(UpdateOrder.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		UpdateOrderRequest updateOrderRequest = gson.fromJson(reader, UpdateOrderRequest.class);
		UpdateOrderResponse updateOrderResponse = new UpdateOrderResponse();
		
		OrderMessage orderMessage = new OrderMessage();
		orderMessage.setOrderId( updateOrderRequest.getOrderId() );
		orderMessage.setStatus( OrderStatus.CONFIRMED );
		
		com.havfun.service.message.UpdateOrderRequest updateRequest = new com.havfun.service.message.UpdateOrderRequest();
		
		updateRequest.setOrderMessage(orderMessage);
		
		LOGGER.info("CreateOrder:: process:: updateRequest: " +  updateRequest );
		com.havfun.service.message.UpdateOrderResponse updateResponse = ClientServiceHelper.getInstance().getClientService().invoke( updateRequest );
		LOGGER.info("CreateOrder:: process:: updateResponse: "+ updateResponse );

		
		if ( updateResponse != null  ){

			updateOrderResponse.setResult( updateResponse.getResult() );
		}else{
			
			updateOrderResponse.setResult( ErrorCode.INTERNAL_ERROR );
			
		}
		
		
		String json = gson.toJson( updateOrderResponse );
		LOGGER.info("UpdateOrder json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	protected boolean isAuthenticationRequired(){
		return true;
	}
	
}