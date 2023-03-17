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
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.message.RemoveCartProductRequest;
import com.havfun.appsservice.message.RemoveCartProductResponse;

/**
 * Servlet implementation class RemoveCartProduct
 */
@WebServlet("/RemoveCartProduct")
public class RemoveCartProduct extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(RemoveCartProduct.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartProduct() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		RemoveCartProductRequest updateCartItemRequest = gson.fromJson(reader, RemoveCartProductRequest.class);
		RemoveCartProductResponse updateCartItemResponse = new RemoveCartProductResponse();


		String session = request.getSession().getId();
		
		List<CartProduct> itemList = new ArrayList<CartProduct>();
		
		if ( cartItemsMap.containsKey( session ) ){
			
			itemList = cartItemsMap.get( session );
			
			itemList.remove( updateCartItemRequest.getIndex() );
						
			cartItemsMap.put( session, itemList);
			
		}
		
		
		String json =gson.toJson( updateCartItemResponse );
		LOGGER.info("RemoveCartProduct json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}