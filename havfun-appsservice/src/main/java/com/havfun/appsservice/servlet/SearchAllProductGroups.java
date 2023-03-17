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
import com.havfun.appsservice.data.ProductGroup;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.SearchAllProductGroupsRequest;
import com.havfun.appsservice.message.SearchAllProductGroupsResponse;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;
import com.havfun.service.message.data.ProductGroupMessage;



/**
 * Servlet implementation class SearchProductGroup
 */
@WebServlet("/SearchAllProductGroups")
public class SearchAllProductGroups extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(SearchAllProductGroups.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAllProductGroups() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		SearchAllProductGroupsRequest searchAllProductGroupsRequest = gson.fromJson(reader, SearchAllProductGroupsRequest.class);
		SearchAllProductGroupsResponse searchAllProductGroupsResponse = new SearchAllProductGroupsResponse();
		
		LOGGER.info("searchAllProductGroupsRequest: " + searchAllProductGroupsRequest );
		
		SearchProductGroupRequest searchRequest = new SearchProductGroupRequest();
		
		LOGGER.info("SearchProductGroup:: process:: searchRequest: "+ searchRequest );
		SearchProductGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchProductGroup:: process:: searchResponse: "+ searchResponse );

		if ( searchResponse == null){
						
		}
		
		List<ProductGroup> productGroupList = new ArrayList<ProductGroup>();
		
		for ( ProductGroupMessage message : searchResponse.getProductGroupMessageList() ){
			
			ProductGroup productGroup = new ProductGroup();
			
			productGroup.setGroupId( message.getProductGroupId() );
			productGroup.setNameEn( message.getNameEn() );
			productGroup.setNameHk( message.getNameEn() );
			productGroup.setNameCn( message.getNameEn() );
			
			String thumbnailUrl = SYSTEM_DOMAIN_URL + "havfun_image/product_group/" + "product_group_0" + message.getProductGroupId() + ".png"; 
			
			productGroup.setThumbnailUrl(thumbnailUrl);
			
			productGroupList.add(productGroup);
		}
		
		searchAllProductGroupsResponse.setProductGroupList(productGroupList);
		
		String json =gson.toJson(searchAllProductGroupsResponse);
		LOGGER.info("SearchProductGroup json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}