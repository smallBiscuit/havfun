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
import com.havfun.appsservice.data.Material;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.SearchMaterialsRequest;
import com.havfun.appsservice.message.SearchMaterialsResponse;
import com.havfun.service.message.SearchMaterialRequest;
import com.havfun.service.message.SearchMaterialResponse;
import com.havfun.service.message.data.MaterialMessage;



/**
 * Servlet implementation class SearchMaterials
 */
@WebServlet("/SearchMaterials")
public class SearchMaterials extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(SearchMaterials.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMaterials() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		SearchMaterialsRequest searchMaterialsRequest = gson.fromJson(reader, SearchMaterialsRequest.class);
		SearchMaterialsResponse searchMaterialsRespone = new SearchMaterialsResponse();
		
		SearchMaterialRequest searchRequest = new SearchMaterialRequest();
		
		searchRequest.setMaterialGroupId( searchMaterialsRequest.getGroupId() );
		
		LOGGER.info("SearchMaterialGroup:: process:: searchRequest: "+ searchRequest );
		SearchMaterialResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchMaterialGroup:: process:: searchResponse: "+ searchResponse );

		if ( searchResponse == null){
						
		}
		
		List<Material> materialList = new ArrayList<Material>();
		
		for ( MaterialMessage message : searchResponse.getMaterialMessageList() ){
			
			Material material = new Material();
			
			material.setMaterialId( message.getMaterialId() );
			material.setMaterialGroupId( message.getMaterialGroupId() );
			
			
			String materialGroupIdString = String.format("%03d", message.getMaterialGroupId() );
			
			String materialIndexString = String.format("%03d", message.getMaterialIndex() );;
			
			String imageUrlFormatter = "havfun_image/material_thumbnail/material_group_%s/material_%s_%s.png";
			
			String fullImageUrl = SYSTEM_DOMAIN_URL + String.format(imageUrlFormatter, materialGroupIdString, materialGroupIdString, materialIndexString );
			
			material.setThumbnailUrl(fullImageUrl);
			
			materialList.add(material);
		}
		
		searchMaterialsRespone.setMaterialList(materialList);
		
		String json =gson.toJson(searchMaterialsRespone);
		LOGGER.info("SearchMaterials json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}