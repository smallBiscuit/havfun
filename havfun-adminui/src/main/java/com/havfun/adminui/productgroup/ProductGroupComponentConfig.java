package com.havfun.adminui.productgroup;

import com.havfun.adminui.servlet.AbstractComponentConfig;
import com.havfun.adminui.webcomponent.WebComponent;

public class ProductGroupComponentConfig extends AbstractComponentConfig {

	public static String PRODUCT_GROUP_ID = "product_group_id";
	public static String PRODUCT_GROUP_NAME_EN = "product_group_name_en";
	public static String PRODUCT_GROUP_IMAGE = "product_group_image";
	public static String PRODUCT_GROUP_PARENT_ID = "product_group_parent_id";
	public static String PRODUCT_GROUP_STATUS = "product_group_status";
	public static String PRODUCT_GROUP_CREATE_TIMESTAMP = "product_group_create_timestamp";	
	public static String PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP = "product_group_last_modified_timestamp";
	
	static {
		
		createModeMap.put(PRODUCT_GROUP_ID,	WebComponent.MODE_HIDDEN );
		createModeMap.put(PRODUCT_GROUP_NAME_EN,	WebComponent.MODE_EDITABLE );
		createModeMap.put(PRODUCT_GROUP_IMAGE,	WebComponent.MODE_EDITABLE );
		createModeMap.put(PRODUCT_GROUP_PARENT_ID,	WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_GROUP_STATUS,	WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_GROUP_CREATE_TIMESTAMP,	WebComponent.MODE_HIDDEN);
		createModeMap.put(PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP,	WebComponent.MODE_HIDDEN);
		
		updateModeMap.put(PRODUCT_GROUP_ID,	WebComponent.MODE_READONLY );
		updateModeMap.put(PRODUCT_GROUP_NAME_EN,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(PRODUCT_GROUP_IMAGE,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(PRODUCT_GROUP_PARENT_ID,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_GROUP_STATUS,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_GROUP_CREATE_TIMESTAMP,	WebComponent.MODE_READONLY);
		updateModeMap.put(PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP,	WebComponent.MODE_READONLY);
		
		readOnlyModeMap.put(PRODUCT_GROUP_ID,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(PRODUCT_GROUP_NAME_EN,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(PRODUCT_GROUP_IMAGE,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(PRODUCT_GROUP_PARENT_ID,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_GROUP_STATUS,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_GROUP_CREATE_TIMESTAMP,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP,	WebComponent.MODE_READONLY);
		
		
	}
	
}