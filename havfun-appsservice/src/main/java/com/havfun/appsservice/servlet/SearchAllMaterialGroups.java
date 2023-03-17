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
import com.havfun.appsservice.data.MaterialGroup;
import com.havfun.appsservice.data.ProductGroup;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.SearchAllMaterialGroupsRequest;
import com.havfun.appsservice.message.SearchAllMaterialGroupsResponse;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.ProductGroupMessage;



/**
 * Servlet implementation class SearchAllMaterialGroups
 */
@WebServlet("/SearchAllMaterialGroups")
public class SearchAllMaterialGroups extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(SearchAllMaterialGroups.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAllMaterialGroups() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		SearchAllMaterialGroupsRequest searchAllMaterialGroupsRequest = gson.fromJson(reader, SearchAllMaterialGroupsRequest.class);
		SearchAllMaterialGroupsResponse searchAllMaterialGroupsResponse = new SearchAllMaterialGroupsResponse();
		

		
		List<MaterialGroup> materialGroupList = new ArrayList<MaterialGroup>();
		
		for ( MaterialGroupMessage message : dataHelper.getMaterialGroupList() ){
			
			MaterialGroup materialGroup = new MaterialGroup();
			
			materialGroup.setMaterialGroupId( message.getMaterialGroupId() );
			materialGroup.setNameEn( message.getNameEn() );
			materialGroup.setNameHk( message.getNameEn() );
			materialGroup.setNameCn( message.getNameEn() );
			
//			String thumbnailUrl = RESOURCE_IMAGE_DOMAIN + "material_group/" + "product_group_0" + message() + ".png"; 
			
//			materialGroup.setThumbnailUrl(thumbnailUrl);
			
			materialGroupList.add(materialGroup);
		}
		
		searchAllMaterialGroupsResponse.setMaterialGroupList(materialGroupList);
		
		String json =gson.toJson(searchAllMaterialGroupsResponse);
		LOGGER.info("SearchProductGroup json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}