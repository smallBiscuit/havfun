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
import com.havfun.appsservice.data.Product;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.SearchProductsRequest;
import com.havfun.appsservice.message.SearchProductsResponse;
import com.havfun.service.message.SearchProductRequest;
import com.havfun.service.message.SearchProductResponse;
import com.havfun.service.message.data.ProductMessage;



/**
 * Servlet implementation class SearchProducts
 */
@WebServlet("/SearchProducts")
public class SearchProducts extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(SearchProducts.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProducts() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		SearchProductsRequest searchProductsRequest = gson.fromJson(reader, SearchProductsRequest.class);
		SearchProductsResponse searchProductsRespone = new SearchProductsResponse();
		
		SearchProductRequest searchRequest = new SearchProductRequest();
		
		searchRequest.setProductGroupId( searchProductsRequest.getGroupId() );
		
		LOGGER.info("SearchProductGroup:: process:: searchRequest: "+ searchRequest );
		SearchProductResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchProductGroup:: process:: searchResponse: "+ searchResponse );

		if ( searchResponse == null){
						
		}
		
		List<Product> productList = new ArrayList<Product>();
		
		for ( ProductMessage message : searchResponse.getProductMessageList() ){
			
			Product product = new Product();
			
			product.setProductId( message.getProductId() );
			product.setProductGroupId( message.getProductGroupId() );
			product.setNameEn( message.getNameEn() );
			product.setNameHk( message.getNameHk() );
			product.setNameCn( message.getNameCn() );
			product.setThumbnailUrl( message.getThumbnailUrl() );
			product.setDesignerClientId( message.getDesignerClientId() );
			product.setModel( message.getModel() );
			product.setStock( message.getStock() );
			product.setManufacturerId( message.getManufacturerId() );
			product.setPrice( message.getPrice() );
			product.setAvailableDate( message.getAvailableDate() );
			product.setWeight( message.getWeight() );
			product.setLength( message.getLength() );
			product.setWidth( message.getWidth() );
			product.setHeight( message.getHeight() );
			product.setSortingOrder( message.getSortingOrder() );
			product.setStockStatus( message.getStockStatus() );
			product.setProductStatus( message.getProductStatus() );
			product.setCreateTimestamp( message.getCreateTimestamp() );
			product.setLastModifiedTimestamp( message.getLastModifiedTimestamp() );
			
			String productIdStr = String.format("%04d", message.getProductId() );
			
			String thumbnailUrl = SYSTEM_DOMAIN_URL + "havfun_image/product/" + "product_" + productIdStr + ".png"; 
			
			product.setThumbnailUrl(thumbnailUrl);
			
			productList.add(product);
		}
		
		searchProductsRespone.setProductList(productList);
		
		String json =gson.toJson(searchProductsRespone);
		LOGGER.info("SearchProducts json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}