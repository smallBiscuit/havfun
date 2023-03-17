package com.havfun.adminui.productgroup;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.webcomponent.WebComponent;

import com.havfun.service.entity.constant.ProductGroupStatus;
import com.havfun.service.entity.constant.Gender;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductGroupMessage;
import com.havfun.service.utils.LabelUtil;

public class ProductGroupHelperImpl implements ProductGroupHelper{

	private static final Logger LOGGER = LogManager.getLogger(ProductGroupHelper.class.getName());
	
	public void prepareProductGroup(HttpServletRequest request, int servletMode) {
		
		List<String> productGroupGroupList = new ArrayList<String>();
		
		List<String> productGroupStatusList = new ArrayList<String>();
		List<String> genderList = new ArrayList<String>();
		List<String> genderLabelList = new ArrayList<String>();
		
		for (ProductGroupStatus productGroupStatus : ProductGroupStatus.values()) {
			productGroupStatusList.add(productGroupStatus.getValue());
		}


		for (Gender gender : Gender.values()) {
			genderList.add(gender.getValue());
			genderLabelList.add( "gender." + gender.getValue());
		}
		
		request.setAttribute("productGroupGroupList", productGroupGroupList);
		request.setAttribute("productGroupStatusList", productGroupStatusList);
		request.setAttribute("productGroupStatusLabelList", productGroupStatusList);
		request.setAttribute("genderList", genderList);
		request.setAttribute("genderLabelList", genderLabelList);
		
		request.setAttribute(PRODUCT_GROUP_ID.getKey(), PRODUCT_GROUP_ID);
		request.setAttribute(PRODUCT_GROUP_NAME_EN.getKey(), PRODUCT_GROUP_NAME_EN);
		request.setAttribute(PRODUCT_GROUP_IMAGE.getKey(), PRODUCT_GROUP_IMAGE);
		request.setAttribute(PRODUCT_GROUP_PARENT_ID.getKey(), PRODUCT_GROUP_PARENT_ID);
		request.setAttribute(PRODUCT_GROUP_STATUS.getKey(), PRODUCT_GROUP_STATUS);
		request.setAttribute(PRODUCT_GROUP_CREATE_TIMESTAMP.getKey(), PRODUCT_GROUP_CREATE_TIMESTAMP);
		request.setAttribute(PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP.getKey(), PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP);
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>)request.getAttribute("ActionMap");
		
		switch (servletMode) {
			case SERVLET_TYPE_CREATE:
				request.setAttribute(NAVIGATOR, "content_product_group_create_product_group");
				request.setAttribute(ACTION, CREATE_PRODUCT_GROUP_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
				break;
			case SERVLET_TYPE_ENQUIRE:
				request.setAttribute(NAVIGATOR, "content_product_group_enquire_product_group");
				if (actionMap.get(UPDATE_PRODUCT_GROUP_REQUEST) != null){
		    		request.setAttribute(ACTION, UPDATE_PRODUCT_GROUP_REQUEST);
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
		    	} else {
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
		    	}
				break;
		}
	}
	
	public ProductGroupMessage getProductGroupMessage(HttpServletRequest request) {
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new File("/tmp"));

		ServletFileUpload uploader = new ServletFileUpload(diskFileItemFactory);

		List<FileItem> fileItemsList = new ArrayList<FileItem>();
		List<FileItem> documentItemList = new ArrayList<FileItem>();

		try {

			fileItemsList =  uploader.parseRequest(request);

			for (FileItem fileItem : fileItemsList) {

				if (fileItem.getContentType() != null) {

					if (fileItem.getSize() > 0) {
						LOGGER.debug("FieldName=" + fileItem.getFieldName());
						LOGGER.debug("Name=" + fileItem.getName());
						LOGGER.debug("ContentType=" + fileItem.getContentType());
						LOGGER.debug("Size=" + fileItem.getSize());
						LOGGER.debug("Length=" + fileItem.get().length);
						
						documentItemList.add(fileItem);
					}
				} else {
					// prevent XSS
					parameterMap.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}

			}
		}catch( Exception e){
			
			LOGGER.warn( "Exception ", e);
			
		}
		
		LOGGER.debug("getProductGroupMessage(): parameterMap: " + parameterMap);
		LOGGER.debug("getProductGroupMessage(): documentItemList: " + documentItemList);
		
		ProductGroupMessage productGroupMessage = new ProductGroupMessage();
		
		String productGroupIdStr = parameterMap.get(PRODUCT_GROUP_ID.getKey());
		String nameEn = parameterMap.get(PRODUCT_GROUP_NAME_EN.getKey());
		String parentId = parameterMap.get(PRODUCT_GROUP_PARENT_ID.getKey());
		String status = parameterMap.get(PRODUCT_GROUP_STATUS.getKey());		
		String createTimestamp = parameterMap.get(PRODUCT_GROUP_CREATE_TIMESTAMP.getKey());
		String lastModifiedTimestamp = parameterMap.get(PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP.getKey());		

				
		if ( LabelUtil.isValidFormValue( productGroupIdStr ) ) {
			try {
				productGroupMessage.setProductGroupId(Integer.parseInt( productGroupIdStr ) );
			} catch (Exception e) {
				
			}
		}
		
		if ( LabelUtil.isValidFormValue( nameEn ) ) {
			
			productGroupMessage.setNameEn( LabelUtil.parseValidFormValue( nameEn ) );
			
		}
		
		if ( documentItemList != null && documentItemList.size() > 0 ){

			FileItem fileItem = documentItemList.get( 0 );
			
			productGroupMessage.setImage( fileItem.get() );
			
			//productGroupMessage.setImage( setFirstName( LabelUtil.parseValidFormValue( productImage ) );

		}
		
		if ( LabelUtil.isValidFormValue( parentId ) ) {
			
			try {
				productGroupMessage.setParentId( Integer.parseInt( parentId ) );
			} catch (Exception e) {
				
			}
		}
		
		if ( LabelUtil.isValidFormValue( status ) ) {
			
			productGroupMessage.setStatus( ProductGroupStatus.fromValue( status ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( createTimestamp ) ) {
			
			productGroupMessage.setCreateTimestamp( Long.parseLong( createTimestamp ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( lastModifiedTimestamp ) ) {
			
			productGroupMessage.setLastModifiedTimestamp( Long.parseLong( lastModifiedTimestamp));
			
		}		
				
		return productGroupMessage;
	}
	
	
	public Map<Integer, ProductGroupMessage> searchProductGroupMessageMap( BaseUser baseUser ){
		
		Map<Integer, ProductGroupMessage> productGroupMessageMap = new HashMap<Integer, ProductGroupMessage>();
		

		AdminSearchProductGroupRequest searchRequest = new AdminSearchProductGroupRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchProductGroup:: process:: searchRequest:: "+ searchRequest );
		AdminSearchProductGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchProductGroup:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null && searchResponse.getResult() == ErrorCode.NO_ERROR ){
			
			if ( searchResponse.getProductGroupMessageList() != null ){
				
				for ( ProductGroupMessage message : searchResponse.getProductGroupMessageList() ){
					
					productGroupMessageMap.put( message.getProductGroupId(), message);
					
				}
				
			}

			
		}
		
		return productGroupMessageMap;
	}
}
