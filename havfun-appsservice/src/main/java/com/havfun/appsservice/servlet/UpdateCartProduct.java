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
import com.havfun.appsservice.message.UpdateCartProductRequest;
import com.havfun.appsservice.message.UpdateCartProductResponse;

/**
 * Servlet implementation class UpdateCartProduct
 */
@WebServlet("/UpdateCartProduct")
public class UpdateCartProduct extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(UpdateCartProduct.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartProduct() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		UpdateCartProductRequest updateCartItemRequest = gson.fromJson(reader, UpdateCartProductRequest.class);
		UpdateCartProductResponse updateCartItemResponse = new UpdateCartProductResponse();


		String session = request.getSession().getId();
		
		List<CartProduct> itemList = new ArrayList<CartProduct>();
		
		if ( cartItemsMap.containsKey( session ) ){
			
			itemList = cartItemsMap.get( session );
			
			CartProduct product = itemList.get( updateCartItemRequest.getIndex() );
			
			product.setOptionMap( updateCartItemRequest.getOptionMap() );
			product.setQuantity( updateCartItemRequest.getQuantity() );
			
			itemList.set( updateCartItemRequest.getIndex(), product);
			
			cartItemsMap.put( session, itemList);
			
		}
		
		
		
		
		String json =gson.toJson( updateCartItemResponse );
		LOGGER.info("UpdateCartProduct json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}