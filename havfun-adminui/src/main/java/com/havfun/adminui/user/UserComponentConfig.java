package com.havfun.adminui.user;

import com.havfun.adminui.servlet.AbstractComponentConfig;
import com.havfun.adminui.webcomponent.WebComponent;

public class UserComponentConfig extends AbstractComponentConfig {

	public static String USER_ID = "user_id";
	public static String USER_GROUP = "user_group";
	public static String USER_NAME = "user_name";
	public static String USER_PASSCODE = "user_passcode";	
	public static String USER_FIRST_NAME = "user_first_name";
	public static String USER_LAST_NAME = "user_last_name";
	public static String USER_EMAIL = "user_email";
	public static String USER_STATUS = "user_status";
	public static String USER_CREATE_TIMESTAMP = "user_create_timestamp";
	
	static {
		
		mandatoryMap.put(USER_NAME, true);
		mandatoryMap.put(USER_EMAIL, true);

		createModeMap.put(USER_ID,		WebComponent.MODE_HIDDEN );
		createModeMap.put(USER_GROUP,	WebComponent.MODE_EDITABLE );
		createModeMap.put(USER_NAME,	WebComponent.MODE_EDITABLE);
		createModeMap.put(USER_PASSCODE,	WebComponent.MODE_EDITABLE);
		createModeMap.put(USER_FIRST_NAME, 	WebComponent.MODE_EDITABLE);
		createModeMap.put(USER_LAST_NAME, 	WebComponent.MODE_EDITABLE);
		createModeMap.put(USER_EMAIL, 		WebComponent.MODE_EDITABLE);
		createModeMap.put(USER_STATUS, WebComponent.MODE_HIDDEN );
		createModeMap.put(USER_CREATE_TIMESTAMP, WebComponent.MODE_HIDDEN);
		
		updateModeMap.put(USER_ID,		WebComponent.MODE_READONLY );
		updateModeMap.put(USER_GROUP,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(USER_NAME,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(USER_PASSCODE,		WebComponent.MODE_EDITABLE);
		updateModeMap.put(USER_FIRST_NAME, 	WebComponent.MODE_EDITABLE);
		updateModeMap.put(USER_LAST_NAME, 	WebComponent.MODE_EDITABLE);
		updateModeMap.put(USER_EMAIL, 		WebComponent.MODE_EDITABLE);
		updateModeMap.put(USER_STATUS, 	WebComponent.MODE_EDITABLE );
		updateModeMap.put(USER_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		
		readOnlyModeMap.put(USER_ID,		WebComponent.MODE_READONLY );
		readOnlyModeMap.put(USER_GROUP,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(USER_NAME,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(USER_PASSCODE,		WebComponent.MODE_READONLY);
		readOnlyModeMap.put(USER_FIRST_NAME, 	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(USER_LAST_NAME, 	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(USER_EMAIL, 		WebComponent.MODE_READONLY);
		readOnlyModeMap.put(USER_STATUS, 	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(USER_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
				
		
	}
	
}