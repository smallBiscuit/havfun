package com.havfun.adminui.client;

import com.havfun.adminui.servlet.AbstractComponentConfig;
import com.havfun.adminui.webcomponent.WebComponent;

public class ClientComponentConfig extends AbstractComponentConfig {

	public static String CLIENT_ID = "client_id";
	public static String CLIENT_FIRST_NAME = "client_first_name";
	public static String CLIENT_LAST_NAME = "client_last_name";
	public static String CLIENT_BIRTH = "client_birth";
	public static String CLIENT_GENDER = "client_gender";	
	public static String CLIENT_EMAIL = "client_email";
	public static String CLIENT_TELEPHONE = "client_telephone";	
	public static String CLIENT_ADDRESS_LIST = "client_address_list";
	public static String CLIENT_FAX = "client_fax";	
	public static String CLIENT_REFERRER_CLIENT_ID = "client_referrer_client_id";
	public static String CLIENT_STORE_ID = "client_store_id";
	public static String CLIENT_NEWSLETTER = "client_newsletter";
	public static String CLIENT_GROUP = "client_group";
	public static String CLIENT_STATUS = "client_status";
	public static String CLIENT_CREATE_TIMESTAMP = "client_create_timestamp";
	
	static {
		
		createModeMap.put(CLIENT_ID,	WebComponent.MODE_HIDDEN );
		createModeMap.put(CLIENT_FIRST_NAME,	WebComponent.MODE_EDITABLE );
		createModeMap.put(CLIENT_LAST_NAME,	WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_BIRTH,	WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_GENDER,	WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_EMAIL,	WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_TELEPHONE,	WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_ADDRESS_LIST,	WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_FAX,	WebComponent.MODE_EDITABLE );
		createModeMap.put(CLIENT_REFERRER_CLIENT_ID, WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_STORE_ID, WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_NEWSLETTER, WebComponent.MODE_EDITABLE);
		createModeMap.put(CLIENT_GROUP, WebComponent.MODE_HIDDEN);
		createModeMap.put(CLIENT_STATUS, WebComponent.MODE_HIDDEN);
		createModeMap.put(CLIENT_CREATE_TIMESTAMP, WebComponent.MODE_HIDDEN);
		
		updateModeMap.put(CLIENT_ID,	WebComponent.MODE_READONLY );
		updateModeMap.put(CLIENT_FIRST_NAME,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(CLIENT_LAST_NAME,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_BIRTH,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_GENDER,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_EMAIL,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_TELEPHONE,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_ADDRESS_LIST,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_FAX,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(CLIENT_REFERRER_CLIENT_ID, WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_STORE_ID, WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_NEWSLETTER, WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_GROUP, WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_STATUS, WebComponent.MODE_EDITABLE);
		updateModeMap.put(CLIENT_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		
		readOnlyModeMap.put(CLIENT_ID,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(CLIENT_FIRST_NAME,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(CLIENT_LAST_NAME,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_BIRTH,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_GENDER,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_EMAIL,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_TELEPHONE,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_ADDRESS_LIST,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_FAX,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(CLIENT_REFERRER_CLIENT_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_STORE_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_NEWSLETTER, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_GROUP, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_STATUS, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CLIENT_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		
		
	}
	
}