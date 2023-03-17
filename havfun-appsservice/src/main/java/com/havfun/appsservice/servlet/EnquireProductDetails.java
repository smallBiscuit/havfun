package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.havfun.appsservice.convertor.ProductConvertor;
import com.havfun.appsservice.data.Product;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.EnquireProductDetailsRequest;
import com.havfun.appsservice.message.EnquireProductDetailsResponse;
import com.havfun.service.message.EnquireProductRequest;
import com.havfun.service.message.EnquireProductResponse;
import com.havfun.service.message.data.ProductMessage;



/**
 * Servlet implementation class EnquireProductDetails
 */
@WebServlet("/EnquireProductDetails")
public class EnquireProductDetails extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(EnquireProductDetails.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireProductDetails() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		EnquireProductDetailsRequest enquireProductDetailsRequest = gson.fromJson(reader, EnquireProductDetailsRequest.class);
		EnquireProductDetailsResponse enquireProductDetailsResponse = new EnquireProductDetailsResponse();
		
		EnquireProductRequest enquireRequest = new EnquireProductRequest();
		
		enquireRequest.setProductId( enquireProductDetailsRequest.getProductId() );
		
		LOGGER.info("EnquireProductDetails:: process:: enquireRequest: "+ enquireRequest );
		EnquireProductResponse enquireResponse = ClientServiceHelper.getInstance().getClientService().invoke( enquireRequest );
		LOGGER.info("EnquireProductDetails:: process:: enquireResponse: "+ enquireResponse );

		if ( enquireResponse == null){
						
		}
		
		ProductMessage message = enquireResponse.getProductMessage();
			
		Product product = ProductConvertor.convertorProductMessageToProduct( message );
		
		String productIdStr = String.format("%04d", message.getProductId() );
		
		String thumbnailUrl = SYSTEM_DOMAIN_URL + "havfun_image/product/" + "product_" + productIdStr + ".png"; 
		
		product.setThumbnailUrl(thumbnailUrl);
		
		
		enquireProductDetailsResponse.setProductDetails( product );
		
		String json =gson.toJson( enquireProductDetailsResponse );
		LOGGER.info("EnquireProduct json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}