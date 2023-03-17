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
import com.havfun.appsservice.convertor.ProductConvertor;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Product;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.CreateCartProductRequest;
import com.havfun.appsservice.message.CreateCartProductResponse;
import com.havfun.service.entity.constant.ProductStatus;
import com.havfun.service.message.CreateClientProductRequest;
import com.havfun.service.message.CreateClientProductResponse;
import com.havfun.service.message.EnquireProductRequest;
import com.havfun.service.message.EnquireProductResponse;
import com.havfun.service.message.data.ClientProductMessage;
import com.havfun.service.message.data.ProductMessage;

/**
 * Servlet implementation class CreateCartProduct
 */
@WebServlet("/CreateCartProduct")
public class CreateCartProduct extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(CreateCartProduct.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCartProduct() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		CreateCartProductRequest createCartItemRequest = gson.fromJson(reader, CreateCartProductRequest.class);
		CreateCartProductResponse createCartItemResponse = new CreateCartProductResponse();

		LOGGER.info("CreateCartProduct createCartItemRequest: "+ createCartItemRequest );
		
		EnquireProductRequest enquireRequest = new EnquireProductRequest();
		
		enquireRequest.setProductId( createCartItemRequest.getProductId() );
		
		LOGGER.info("CreateCartProduct:: process:: enquireRequest: "+ enquireRequest );
		EnquireProductResponse enquireResponse = ClientServiceHelper.getInstance().getClientService().invoke( enquireRequest );
		LOGGER.info("CreateCartProduct:: process:: enquireResponse: "+ enquireResponse );

		ProductMessage message = enquireResponse.getProductMessage();
		
		Product product = ProductConvertor.convertorProductMessageToProduct( message );
		
		ClientProductMessage clientProduct = new ClientProductMessage();
		
		clientProduct.setProductStatus( ProductStatus.ACTIVE );
		
		CreateClientProductRequest createClientProductRequest = new CreateClientProductRequest();
		
		CreateClientProductResponse createClientProductResponse = ClientServiceHelper.getInstance().getClientService().invoke( createClientProductRequest );
		
		
		CartProduct item = new CartProduct();
		
		item.setKey( "rayTest" );
		item.setProductId( createCartItemRequest.getProductId() );
		item.setQuantity( 1 );		
		item.setPrice( product.getPrice() );
		item.setWeight( product.getWeight() );
		item.setAttributeList( product.getCustomizeProductBase().getAttributeList() );
		item.setOptionMap( createCartItemRequest.getOptionMap() );
		
		
		
		String session = request.getSession().getId();
		
		if ( cartItemsMap.containsKey( session ) ){
			
			List<CartProduct> itemList = cartItemsMap.get( session );
			itemList.add(item);
			
			cartItemsMap.put( session, itemList );			
			
		}else{
			
			List<CartProduct> itemList = new ArrayList<CartProduct>();
			itemList.add(item);
			
			cartItemsMap.put( session, itemList );
			
		}
		
		LOGGER.info("CreateCartProduct cartItemsMap: "+ cartItemsMap );
	    
		
		createCartItemResponse.setCartProductId( createClientProductResponse.getClientProductId() );
		
		String json =gson.toJson( createCartItemResponse );
		LOGGER.info("CreateCartProduct json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}