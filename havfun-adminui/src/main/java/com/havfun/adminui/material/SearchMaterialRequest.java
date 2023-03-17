package com.havfun.adminui.material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.helper.LocalizationHelper;
import com.havfun.adminui.materialgroup.MaterialGroupHelperImpl;
import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.adminui.utils.LabelUtils;
import com.havfun.service.message.admin.material.AdminSearchMaterialRequest;
import com.havfun.service.message.admin.material.AdminSearchMaterialResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.MaterialMessage;

/**
 * Servlet implementation class SearchMaterialRequest
 */
@WebServlet("/SearchMaterialRequest")
public class SearchMaterialRequest extends AbstractServlet{

	private static final Logger LOGGER = LogManager.getLogger(SearchMaterial.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMaterialRequest() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String materialGroupIdStr = request.getParameter( "materialGroupId" );
		
		int materialGroupId = -1;
		int result = 0;
		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);

		List<Map<String, String>> dataMapList = new ArrayList<Map<String, String>>();		
		
		MaterialGroupHelperImpl materialGroupHelper = new MaterialGroupHelperImpl();
		Map<Integer, MaterialGroupMessage> materialGroupMap = materialGroupHelper.searchMaterialGroupMessageMap(baseUser);
		
		try{
			materialGroupId = Integer.parseInt( materialGroupIdStr );
		}catch( Exception e){
			LOGGER.warn( "Exception ", e );
		}
		
		AdminSearchMaterialRequest searchRequest = new AdminSearchMaterialRequest();
		searchRequest.setLoginUserId(baseUser.getId());
		searchRequest.setToken(baseUser.getToken());

		searchRequest.setMaterialGroupId(materialGroupId);
		
		LOGGER.info("SearchMaterial:: process:: searchRequest:: " + searchRequest);
		AdminSearchMaterialResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke(searchRequest);
		LOGGER.info("SearchMaterial:: process:: searchResponse:: " + searchResponse);

		if (searchResponse != null) {
			
			if ( searchResponse.getMaterialMessageList() != null ){
				
				for ( MaterialMessage message : searchResponse.getMaterialMessageList() ){
					
					Map<String, String> rowDataMap = new HashMap<String, String>();
					
					rowDataMap.put( "td_material_id", "" + message.getMaterialId() );
					
					MaterialGroupMessage materialGroupMessage = materialGroupMap.get( message.getMaterialGroupId() );
					
					if ( materialGroupMessage != null ){
					
						rowDataMap.put( "td_material_group", materialGroupMessage.getNameEn() + "(" + materialGroupMessage.getMaterialGroupId() + ")" );
					
					}else{
						
						rowDataMap.put( "td_material_group", "-" );
								
					}
					
					rowDataMap.put( "td_material_index", "" + message.getMaterialIndex() );
					
					String materialGroupIdString = String.format("%03d", message.getMaterialGroupId() );
					
					String materialIndexString = String.format("%03d", message.getMaterialIndex() );;
					
					String imageUrlFormatter = "havfun_image/material_thumbnail/material_group_%s/material_%s_%s.png";
					
					String fullImageUrl = SYSTEM_DOMAIN_URL + String.format(imageUrlFormatter, materialGroupIdString, materialGroupIdString, materialIndexString );
					
					rowDataMap.put( "td_full_image_url", fullImageUrl );
					
					dataMapList.add(rowDataMap);
					
				}
				
			}
			
			
			
		}
				
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String lang = (String) request.getAttribute("SelectedLang");
		ResourceBundle labels = LocalizationHelper.getResourceBundle("Result", lang);
		jsonMap.put("dataMapList", dataMapList );

		jsonMap.put("resultCode", result);
		if (result != ErrorCode.INTERNAL_ERROR){
			jsonMap.put("resultMessage", LabelUtils.getDisplayValueFromResourceBundle(labels , "error_result." + result) );
		}else{
			jsonMap.put("resultMessage", LabelUtils.getDisplayValueFromResourceBundle(labels , "error_result.-999") );
		}
			
		String jsonList = new Gson().toJson(jsonMap);
		response.setCharacterEncoding("UTF-8");                
		response.getWriter().write(jsonList);    	        	
		request.setAttribute("json", jsonList);

	}
	
}
