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
import com.havfun.appsservice.data.Cart;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.message.EnquireCartDetailsRequest;
import com.havfun.appsservice.message.EnquireCartDetailsResponse;

/**
 * Servlet implementation class EnquireCartDetails
 */
@WebServlet("/EnquireCartDetails")
public class EnquireCartDetails extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(EnquireCartDetails.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireCartDetails() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		EnquireCartDetailsRequest enquireCartItemsRequest = gson.fromJson(reader, EnquireCartDetailsRequest.class);
		EnquireCartDetailsResponse enquireCartItemsResponse = new EnquireCartDetailsResponse();

		Cart cart = new Cart();
		
		String session = request.getSession().getId();
		
		List<CartProduct> itemList = new ArrayList<CartProduct>();
		
		LOGGER.info("EnquireCartDetails 1 cartItemsMap: "+ cartItemsMap );
		
		LOGGER.info("EnquireCartDetails 2 sessionId: "+ session );
		
		if ( cartItemsMap.containsKey( session ) ){
						
			itemList = cartItemsMap.get( session );
			
			LOGGER.info("EnquireCartDetails 3 getSession: "+ cartItemsMap.get( session ) );
			
			LOGGER.info("EnquireCartDetails 3 itemList: "+ itemList );
		}
		
		cart.setProducts(itemList);
		
		enquireCartItemsResponse.setCart(cart);
		
		String json =gson.toJson( enquireCartItemsResponse );
		LOGGER.info("EnquireCartDetails json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}