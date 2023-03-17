package com.havfun.adminui.materialgroup;

import com.havfun.adminui.servlet.AbstractComponentConfig;
import com.havfun.adminui.webcomponent.WebComponent;

public class MaterialGroupComponentConfig extends AbstractComponentConfig {

	public static String MATERIAL_GROUP_ID = "material_group_id";
	public static String MATERIAL_GROUP_NAME_EN = "material_group_name_en";
	public static String MATERIAL_GROUP_IMAGE = "material_group_image";
	public static String MATERIAL_GROUP_PARENT_ID = "material_group_parent_id";
	public static String MATERIAL_GROUP_STATUS = "material_group_status";
	public static String MATERIAL_GROUP_CREATE_TIMESTAMP = "material_group_create_timestamp";	
	public static String MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP = "material_group_last_modified_timestamp";
	
	static {
		
		createModeMap.put(MATERIAL_GROUP_ID,	WebComponent.MODE_HIDDEN );
		createModeMap.put(MATERIAL_GROUP_NAME_EN,	WebComponent.MODE_EDITABLE );
		createModeMap.put(MATERIAL_GROUP_IMAGE,	WebComponent.MODE_EDITABLE );
		createModeMap.put(MATERIAL_GROUP_PARENT_ID,	WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_GROUP_STATUS,	WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_GROUP_CREATE_TIMESTAMP,	WebComponent.MODE_HIDDEN);
		createModeMap.put(MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP,	WebComponent.MODE_HIDDEN);
		
		updateModeMap.put(MATERIAL_GROUP_ID,	WebComponent.MODE_READONLY );
		updateModeMap.put(MATERIAL_GROUP_NAME_EN,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(MATERIAL_GROUP_IMAGE,	WebComponent.MODE_EDITABLE );
		updateModeMap.put(MATERIAL_GROUP_PARENT_ID,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_GROUP_STATUS,	WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_GROUP_CREATE_TIMESTAMP,	WebComponent.MODE_READONLY);
		updateModeMap.put(MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP,	WebComponent.MODE_READONLY);
		
		readOnlyModeMap.put(MATERIAL_GROUP_ID,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(MATERIAL_GROUP_NAME_EN,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(MATERIAL_GROUP_IMAGE,	WebComponent.MODE_READONLY );
		readOnlyModeMap.put(MATERIAL_GROUP_PARENT_ID,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_GROUP_STATUS,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_GROUP_CREATE_TIMESTAMP,	WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP,	WebComponent.MODE_READONLY);
		
		
	}
	
}