package com.havfun.adminui.client;

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

import com.havfun.service.entity.constant.ClientStatus;
import com.havfun.service.entity.constant.Gender;
import com.havfun.service.message.data.AddressMessage;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.utils.LabelUtil;

public class ClientHelperImpl implements ClientHelper{

	private static final Logger LOGGER = LogManager.getLogger(ClientHelper.class.getName());
	
	public void prepareClient(HttpServletRequest request, int servletMode) {
		
		List<String> clientGroupList = new ArrayList<String>();
		
		List<String> clientStatusList = new ArrayList<String>();
		List<String> genderList = new ArrayList<String>();
		List<String> genderLabelList = new ArrayList<String>();
		
		for (ClientStatus clientStatus : ClientStatus.values()) {
			clientStatusList.add(clientStatus.getValue());
		}


		for (Gender gender : Gender.values()) {
			genderList.add(gender.getValue());
			genderLabelList.add( "gender." + gender.getValue());
		}
		
		request.setAttribute("clientGroupList", clientGroupList);
		request.setAttribute("clientStatusList", clientStatusList);
		request.setAttribute("clientStatusLabelList", clientStatusList);
		request.setAttribute("genderList", genderList);
		request.setAttribute("genderLabelList", genderLabelList);
		
		request.setAttribute(CLIENT_ID.getKey(), CLIENT_ID);
		request.setAttribute(CLIENT_FIRST_NAME.getKey(), CLIENT_FIRST_NAME);
		request.setAttribute(CLIENT_LAST_NAME.getKey(), CLIENT_LAST_NAME);
		request.setAttribute(CLIENT_BIRTH.getKey(), CLIENT_BIRTH);
		request.setAttribute(CLIENT_GENDER.getKey(), CLIENT_GENDER);
		request.setAttribute(CLIENT_EMAIL.getKey(), CLIENT_EMAIL);
		request.setAttribute(CLIENT_TELEPHONE.getKey(), CLIENT_TELEPHONE);
		request.setAttribute(CLIENT_FAX.getKey(), CLIENT_FAX);
		request.setAttribute(CLIENT_ADDRESS_LIST.getKey(), CLIENT_ADDRESS_LIST);		
		request.setAttribute(CLIENT_REFERRER_CLIENT_ID.getKey(), CLIENT_REFERRER_CLIENT_ID);
		
		request.setAttribute(CLIENT_STORE_ID.getKey(), CLIENT_STORE_ID);
		request.setAttribute(CLIENT_NEWSLETTER.getKey(), CLIENT_NEWSLETTER);
		request.setAttribute(CLIENT_GROUP.getKey(), CLIENT_GROUP);
		request.setAttribute(CLIENT_STATUS.getKey(), CLIENT_STATUS);
		request.setAttribute(CLIENT_CREATE_TIMESTAMP.getKey(), CLIENT_CREATE_TIMESTAMP);
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>)request.getAttribute("ActionMap");
		
		switch (servletMode) {
			case SERVLET_TYPE_CREATE:
				request.setAttribute(NAVIGATOR, "content_client_create_client");
				request.setAttribute(ACTION, CREATE_CLIENT_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
				break;
			case SERVLET_TYPE_ENQUIRE:
				request.setAttribute(NAVIGATOR, "content_client_enquire_client");
				if (actionMap.get(UPDATE_CLIENT_REQUEST) != null){
		    		request.setAttribute(ACTION, UPDATE_CLIENT_REQUEST);
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
		    	} else {
		    		request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
		    	}
				break;
		}
	}
	
	public ClientMessage getClientMessage(HttpServletRequest request) {
		
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
		
		LOGGER.debug("getClientMessage(): parameterMap: " + parameterMap);
		
		
		ClientMessage clientMessage = new ClientMessage();
		
		String clientIdStr = parameterMap.get(CLIENT_ID.getKey());
		String firstName = parameterMap.get(CLIENT_FIRST_NAME.getKey());
		String lastName = parameterMap.get(CLIENT_LAST_NAME.getKey());
		String birth = parameterMap.get(CLIENT_BIRTH.getKey());		
		String gender = parameterMap.get(CLIENT_GENDER.getKey());
		String email = parameterMap.get(CLIENT_EMAIL.getKey());		
		String telephone = parameterMap.get(CLIENT_TELEPHONE.getKey());
		String fax = parameterMap.get(CLIENT_FAX.getKey());
		String referrerClientIdStr = parameterMap.get(CLIENT_REFERRER_CLIENT_ID.getKey());
		String storeIdStr = parameterMap.get(CLIENT_STORE_ID.getKey());
		String newsLetter = parameterMap.get(CLIENT_NEWSLETTER.getKey());
		String clientGroup = parameterMap.get(CLIENT_GROUP.getKey());
		String status = parameterMap.get(CLIENT_STATUS.getKey());
				
		if ( LabelUtil.isValidFormValue( clientIdStr ) ) {
			try {
				clientMessage.setClientId(Integer.parseInt( clientIdStr ) );
			} catch (Exception e) {
				
			}
		}
		
		if ( LabelUtil.isValidFormValue( firstName ) ){

			clientMessage.setFirstName( LabelUtil.parseValidFormValue( firstName ) );

		}
		
		if ( LabelUtil.isValidFormValue( lastName ) ) {
			
			clientMessage.setLastName( LabelUtil.parseValidFormValue( lastName ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( birth ) ) {
			
//			clientMessage.setBirth( Integer.parseInt( birth ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( gender ) ) {
			
			clientMessage.setGender( LabelUtil.parseValidFormValue( gender ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( email ) ) {
			
			clientMessage.setEmail( LabelUtil.parseValidFormValue( email ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( telephone ) ) {
			
			clientMessage.setTelephone( LabelUtil.parseValidFormValue( telephone ) );
			
		}

		if ( LabelUtil.isValidFormValue( fax ) ) {
			
			clientMessage.setFax( LabelUtil.parseValidFormValue( fax ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( referrerClientIdStr ) ) {
			
			clientMessage.setReferrerClientId( Integer.parseInt( referrerClientIdStr ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( storeIdStr ) ) {
			
			clientMessage.setStoreId( Integer.parseInt( storeIdStr ) );
			
		}

		if ( newsLetter!= null && newsLetter.equals("on")) {
			
			clientMessage.setNewsletter( true );
			
		}

		if ( LabelUtil.isValidFormValue( clientGroup ) ) {
			
			clientMessage.setClientGroup( LabelUtil.parseValidFormValue( clientGroup ) );
			
		}
		
		if ( LabelUtil.isValidFormValue( status ) ) {
			
			clientMessage.setStatus( ClientStatus.fromValue( status ) );
			
		}			
		
		boolean findNext = true;
		int index = 0;
		
		List<AddressMessage> addressList = new ArrayList<AddressMessage>();
		
		do{
			
			String addressIdStr = parameterMap.get("address_id_" + index);
			String addressClientIdStr = parameterMap.get("address_client_id_" + index);
			String addressFirstName = parameterMap.get( "address_first_name_" + index);
			String addressLastName = parameterMap.get( "address_last_name_" + index);
			String addressCity = parameterMap.get( "address_city_" + index);
			String addressPostcode = parameterMap.get( "address_postcode_" + index);
			String addressCountry = parameterMap.get( "address_country_id_" + index);
			String addressZoneId = parameterMap.get( "address_zone_id_" + index);
			String addressTelephone = parameterMap.get( "address_telephone_" + index);
			
			AddressMessage addressMessage = new AddressMessage();
						
			if ( addressFirstName == null || addressLastName == null ){
				
				findNext = false;
				
			}else{
			
				if ( LabelUtil.isValidFormValue( addressIdStr ) ) {
					
					try{
						addressMessage.setAddressId( Integer.parseInt( addressIdStr ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
					
				if ( LabelUtil.isValidFormValue( addressClientIdStr ) ) {
					
					try{
						addressMessage.setClientId( Integer.parseInt( addressClientIdStr ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( addressFirstName ) ) {
					
					addressMessage.setFirstName( LabelUtil.parseValidFormValue( addressFirstName ) );

				}
				
				if ( LabelUtil.isValidFormValue( addressLastName ) ) {
					
					addressMessage.setLastName( LabelUtil.parseValidFormValue( addressLastName ) );

				}
				
				if ( LabelUtil.isValidFormValue( addressCity ) ) {
					
					addressMessage.setCity( LabelUtil.parseValidFormValue( addressCity ) );

				}
				
				if ( LabelUtil.isValidFormValue( addressPostcode ) ) {
					
					addressMessage.setPostcode( LabelUtil.parseValidFormValue( addressPostcode ) );

				}
				
				if ( LabelUtil.isValidFormValue( addressCountry ) ) {
					
					try{
						addressMessage.setCountryId( Integer.parseInt( addressCountry ) );
					}catch( Exception e){						
						LOGGER.warn("Exception ", e );
					}
				}
				
				if ( LabelUtil.isValidFormValue( addressZoneId ) ) {
					
					try{
						addressMessage.setZoneId( Integer.parseInt( addressZoneId ) );
					}catch( Exception e){						
						LOGGER.warn("Exception ", e );
					}

				}
				
				if ( LabelUtil.isValidFormValue( addressTelephone ) ) {
					
					addressMessage.setTelephone( LabelUtil.parseValidFormValue( addressTelephone ) );

				}
			
				addressList.add( addressMessage );
				
				index ++;
			}
			
		}while( findNext );
		
		clientMessage.setAddressList(addressList);
				
		return clientMessage;
	}
		
}
