package com.havfun.adminui.materialgroup;

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

import com.havfun.service.entity.constant.MaterialGroupStatus;
import com.havfun.service.entity.constant.Gender;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.utils.LabelUtil;

public class MaterialGroupHelperImpl implements MaterialGroupHelper{

	private static final Logger LOGGER = LogManager.getLogger(MaterialGroupHelper.class.getName());
	
	public void prepareMaterialGroup(HttpServletRequest request, int servletMode) {
		
		List<String> materialGroupGroupList = new ArrayList<String>();
		
		List<String> materialGroupStatusList = new ArrayList<String>();
		List<String> genderList = new ArrayList<String>();
		List<String> genderLabelList = new ArrayList<String>();
		
		for (MaterialGroupStatus materialGroupStatus : MaterialGroupStatus.values()) {
			materialGroupStatusList.add(materialGroupStatus.getValue());
		}


		for (Gender gender : Gender.values()) {
			genderList.add(gender.getValue());
			genderLabelList.add( "gender." + gender.getValue());
		}
		
		request.setAttribute("materialGroupGroupList", materialGroupGroupList);
		request.setAttribute("materialGroupStatusList", materialGroupStatusList);
		request.setAttribute("materialGroupStatusLabelList", materialGroupStatusList);
		request.setAttribute("genderList", genderList);
		request.setAttribute("genderLabelList", genderLabelList);
		
		request.setAttribute(MATERIAL_GROUP_ID.getKey(), MATERIAL_GROUP_ID);
		request.setAttribute(MATERIAL_GROUP_NAME_EN.getKey(), MATERIAL_GROUP_NAME_EN);
		request.setAttribute(MATERIAL_GROUP_IMAGE.getKey(), MATERIAL_GROUP_IMAGE);
		request.setAttribute(MATERIAL_GROUP_PARENT_ID.getKey(), MATERIAL_GROUP_PARENT_ID);
		request.setAttribute(MATERIAL_GROUP_STATUS.getKey(), MATERIAL_GROUP_STATUS);
		request.setAttribute(MATERIAL_GROUP_CREATE_TIMESTAMP.getKey(), MATERIAL_GROUP_CREATE_TIMESTAMP);
		request.setAttribute(MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP.getKey(), MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP);
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>)request.getAttribute("ActionMap");
		
		switch (servletMode) {
			case SERVLET_TYPE_CREATE:
				request.setAttribute(NAVIGATOR, "content_material_group_create_material_group");
				request.setAttribute(ACTION, CREATE_MATERIAL_GROUP_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
				break;
			case SERVLET_TYPE_ENQUIRE:
				request.setAttribute(NAVIGATOR, "content_material_group_enquire_material_group");
				if (actionMap.get(UPDATE_MATERIAL_GROUP_REQUEST) != null){
		    		request.setAttribute(ACTION, UPDATE_MATERIAL_GROUP_REQUEST);
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
		    	} else {
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
		    	}
				break;
		}
	}
	
	public MaterialGroupMessage getMaterialGroupMessage(HttpServletRequest request) {
		
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
		
		LOGGER.debug("getMaterialGroupMessage(): parameterMap: " + parameterMap);
		LOGGER.debug("getMaterialGroupMessage(): documentItemList: " + documentItemList);
		
		MaterialGroupMessage materialGroupMessage = new MaterialGroupMessage();
		
		String materialGroupIdStr = parameterMap.get(MATERIAL_GROUP_ID.getKey());
		String nameEn = parameterMap.get(MATERIAL_GROUP_NAME_EN.getKey());
		String parentId = parameterMap.get(MATERIAL_GROUP_PARENT_ID.getKey());
		String status = parameterMap.get(MATERIAL_GROUP_STATUS.getKey());		
		String createTimestamp = parameterMap.get(MATERIAL_GROUP_CREATE_TIMESTAMP.getKey());
		String lastModifiedTimestamp = parameterMap.get(MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP.getKey());		

				
		if ( LabelUtil.isValidFormValue( materialGroupIdStr ) ) {
			try {
				materialGroupMessage.setMaterialGroupId(Integer.parseInt( materialGroupIdStr ) );
			} catch (Exception e) {
				
			}
		}
		
		if ( LabelUtil.isValidFormValue( nameEn ) ) {
			
			materialGroupMessage.setNameEn( LabelUtil.parseValidFormValue( nameEn ) );
			
		}
		
		if ( documentItemList != null && documentItemList.size() > 0 ){

			FileItem fileItem = documentItemList.get( 0 );
			
			materialGroupMessage.setImage( fileItem.get() );
			
			//materialGroupMessage.setImage( setFirstName( LabelUtil.parseValidFormValue( materialImage ) );

		}
		
		if ( LabelUtil.isValidFormValue( parentId ) ) {
			
			try {
				materialGroupMessage.setParentId( Integer.parseInt( parentId ) );
			} catch (Exception e) {
				
			}
		}
		
		if ( LabelUtil.isValidFormValue( status ) ) {
			
			materialGroupMessage.setActive( true );
			
		}
		
		if ( LabelUtil.isValidFormValue( createTimestamp ) ) {
			
			materialGroupMessage.setCreateTimestamp( Long.parseLong( createTimestamp ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( lastModifiedTimestamp ) ) {
			
			materialGroupMessage.setLastModifiedTimestamp( Long.parseLong( lastModifiedTimestamp));
			
		}		
				
		return materialGroupMessage;
	}
	
	
	public Map<Integer, MaterialGroupMessage> searchMaterialGroupMessageMap( BaseUser baseUser ){
		
		Map<Integer, MaterialGroupMessage> materialGroupMessageMap = new HashMap<Integer, MaterialGroupMessage>();
		

		AdminSearchMaterialGroupRequest searchRequest = new AdminSearchMaterialGroupRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchMaterialGroup:: process:: searchRequest:: "+ searchRequest );
		AdminSearchMaterialGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchMaterialGroup:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null && searchResponse.getResult() == ErrorCode.NO_ERROR ){
			
			if ( searchResponse.getMaterialGroupMessageList() != null ){
				
				for ( MaterialGroupMessage message : searchResponse.getMaterialGroupMessageList() ){
					
					materialGroupMessageMap.put( message.getMaterialGroupId(), message);
					
				}
				
			}

			
		}
		
		return materialGroupMessageMap;
	}
}
