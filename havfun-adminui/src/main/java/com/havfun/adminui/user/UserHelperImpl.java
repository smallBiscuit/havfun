package com.havfun.adminui.user;

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

import com.havfun.adminui.webcomponent.WebComponent;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.entity.constant.UserStatus;
import com.havfun.service.message.data.UserMessage;
import com.havfun.service.utils.LabelUtil;

public class UserHelperImpl implements UserHelper{

	private static final Logger LOGGER = LogManager.getLogger(UserHelper.class.getName());
	

	public void prepareUser(HttpServletRequest request, int servletMode) {
				
		List<String> userGroupList = new ArrayList<String>();
		
		List<String> userStatusList = new ArrayList<String>();
		
        for ( UserGroup userGroup: UserGroup.values() ){
        	userGroupList.add( userGroup.getValue() );
        }
        
		for (UserStatus userStatus : UserStatus.values()) {
			userStatusList.add(userStatus.getValue());
		}
		
		request.setAttribute("userGroupList", userGroupList);
		request.setAttribute("userStatusList", userStatusList);
		
		request.setAttribute(USER_ID.getKey(), USER_ID);
		request.setAttribute(USER_GROUP.getKey(), USER_GROUP);
		request.setAttribute(USER_NAME.getKey(), USER_NAME);
		request.setAttribute(USER_PASSCODE.getKey(), USER_PASSCODE);
		request.setAttribute(USER_FIRST_NAME.getKey(), USER_FIRST_NAME);
		request.setAttribute(USER_LAST_NAME.getKey(), USER_LAST_NAME);
		request.setAttribute(USER_EMAIL.getKey(), USER_EMAIL);
		request.setAttribute(USER_STATUS.getKey(), USER_STATUS);
		request.setAttribute(USER_CREATE_TIMESTAMP.getKey(), USER_CREATE_TIMESTAMP);
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>)request.getAttribute("ActionMap");
		
		switch (servletMode) {
			case SERVLET_TYPE_CREATE:
				request.setAttribute(NAVIGATOR, "content_user_create_user");
				request.setAttribute(ACTION, CREATE_USER_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
				break;
			case SERVLET_TYPE_ENQUIRE:
				request.setAttribute(NAVIGATOR, "content_user_enquire_user");
				if (actionMap.get(UPDATE_USER_REQUEST) != null){
		    		request.setAttribute(ACTION, UPDATE_USER_REQUEST);
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
		    	} else {
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
		    	}
				break;
		}
	}
	
	public UserMessage getUserMessage(HttpServletRequest request) {
		
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
		
		LOGGER.debug("getUserMessage(): parameterMap: " + parameterMap);
		
		UserMessage userMessage = new UserMessage();
		
		String userIdString = parameterMap.get(USER_ID.getKey());
		String userGroupString = parameterMap.get(USER_GROUP.getKey());
		String userName = parameterMap.get(USER_NAME.getKey());
		String passcode = parameterMap.get(USER_PASSCODE.getKey());		
		String firstName = parameterMap.get(USER_FIRST_NAME.getKey());
		String lastName = parameterMap.get(USER_LAST_NAME.getKey());		
		String email = parameterMap.get(USER_EMAIL.getKey());
		String userStatusString = parameterMap.get(USER_STATUS.getKey());
		String createTimestampString = parameterMap.get(USER_CREATE_TIMESTAMP.getKey());

		
		if ( LabelUtil.isValidFormValue( userIdString ) ) {
			try {
				userMessage.setUserId(Integer.parseInt(userIdString));
			} catch (Exception e) {
				
			}
		}
		
		if ( LabelUtil.isValidFormValue( userGroupString ) ){
			try{
				userMessage.setUserGroup( UserGroup.fromValue(userGroupString));
			} catch (Exception e) {
				LOGGER.warn("UserGroup.fromValue Exception...", e.getMessage());
			}
		}
		
		if ( LabelUtil.isValidFormValue( userName ) ) {
			userMessage.setUserName( LabelUtil.parseValidFormValue( userName ));
		}
		
		if ( LabelUtil.isValidFormValue( passcode ) ) {
			userMessage.setPasscode( LabelUtil.parseValidFormValue( passcode ) );
		}
		
		if ( LabelUtil.isValidFormValue( firstName ) ) {
			userMessage.setFirstName( LabelUtil.parseValidFormValue( firstName ) );
		}
		
		if ( LabelUtil.isValidFormValue( lastName ) ) {
			userMessage.setLastName( LabelUtil.parseValidFormValue( lastName ) );
		}
		
		if ( LabelUtil.isValidFormValue( email ) ) {
			userMessage.setEmail( LabelUtil.parseValidFormValue( email ) );
		}
		
		if ( LabelUtil.isValidFormValue( userStatusString ) ) {
			try {
				userMessage.setStatus(UserStatus.fromValue(userStatusString));
			} catch (Exception e) {
				LOGGER.warn("UserRole.fromValue Exception...", e.getMessage());
			}
		}
		
		if ( LabelUtil.isValidFormValue( createTimestampString ) ) {
			userMessage.setCreateTimestamp( Long.parseLong( createTimestampString ));
		}
				

				
		return userMessage;
	}
	
}
