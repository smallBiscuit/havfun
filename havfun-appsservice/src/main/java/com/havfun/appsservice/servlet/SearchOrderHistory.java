package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
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
import com.havfun.appsservice.convertor.OrderConvertor;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.Order;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.SearchOrderHistoryRequest;
import com.havfun.appsservice.message.SearchOrderHistoryResponse;
import com.havfun.service.message.SearchOrderRequest;
import com.havfun.service.message.SearchOrderResponse;
import com.havfun.service.message.UpdateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;

/**
 * Servlet implementation class SearchOrderHistory
 */
@WebServlet("/SearchOrderHistory")
public class SearchOrderHistory extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(SearchOrderHistory.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderHistory() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		SearchOrderHistoryRequest searchOrderHistoryRequest = gson.fromJson(reader, SearchOrderHistoryRequest.class);
		SearchOrderHistoryResponse searchOrderHistoryResponse = new SearchOrderHistoryResponse();

		int result = ErrorCode.NO_ERROR;
		BaseClient baseClient = (BaseClient)request.getAttribute( LOGON_CLIENT );
		
		SearchOrderRequest searchRequest = new SearchOrderRequest();
		
		searchRequest.setClientId( baseClient.getClientId() );
		searchRequest.setToken( baseClient.getToken() );
		
		LOGGER.info("SearchOrderHistory:: process:: searchRequest:: "+ searchRequest );
		SearchOrderResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchOrderHistory:: process:: searchResponse:: "+ searchResponse );
			
		if ( searchResponse != null ){
			
			result = searchResponse.getResult();
			
			List<Order> orderList = new ArrayList<Order>();
			
			if ( result == ErrorCode.NO_ERROR && searchResponse.getOrderMessageList() != null ){
				
				for ( OrderMessage orderMessage:searchResponse.getOrderMessageList() ){
					
					Order order = OrderConvertor.convertOrderMessageToOrder(orderMessage);
					
					orderList.add(order);
				}
				
				searchOrderHistoryResponse.setOrderList(orderList);
			}
			
		}else{
			
			result = ErrorCode.INTERNAL_ERROR;
			
		}
		
		searchOrderHistoryResponse.setResult(result);
		
		String json = gson.toJson( searchOrderHistoryResponse );
		LOGGER.info("SearchOrderHistory json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	protected boolean isAuthenticationRequired(){
		return true;
	}
	
}
