package com.havfun.adminui.material;

import com.havfun.adminui.servlet.AbstractComponentConfig;
import com.havfun.adminui.webcomponent.WebComponent;

public class MaterialComponentConfig extends AbstractComponentConfig {

	public static String MATERIAL_ID = "material_id";
	public static String MATERIAL_GROUP_ID = "material_group_id";
	public static String MATERIAL_NAME_EN = "material_name_en";
	public static String MATERIAL_NAME_HK = "material_name_hk";
	public static String MATERIAL_NAME_CN = "material_name_cn";
	public static String MATERIAL_THUMBNAIL_URL = "material_thumbnail_url";
	public static String MATERIAL_DESIGNER_CLIENT_ID = "material_designer_client_id";
	public static String MATERIAL_MODEL = "material_model";
	public static String MATERIAL_STOCK = "material_stock";
	public static String MATERIAL_MANUFACTURER_ID = "material_manufacturer_id"; 
	public static String MATERIAL_PRICE = "material_price";
	public static String MATERIAL_AVAILABLED_DATE = "material_available_date";
	public static String MATERIAL_WEIGHT = "material_weight";
	public static String MATERIAL_LENGTH = "material_length";
	public static String MATERIAL_WIDTH = "material_width";
	public static String MATERIAL_HEIGHT = "material_height";
	public static String MATERIAL_SORTING_ORDER = "material_sorting_order";
	public static String MATERIAL_STOCK_STATUS = "material_stock_status";
	public static String MATERIAL_STATUS = "material_status";
	public static String MATERIAL_CREATE_TIMESTAMP = "material_create_timestamp";
	public static String MATERIAL_LAST_MODIFIED_TIMESTAMP = "material_last_modified_timestamp";

	public static String MATERIAL_CUSTOMIZE_MATERIAL_BASE = "material_customize_material_base";
	
	public static String MATERIAL_CUSTOMIZE_MATERIAL_COLOR_DETAILS_LIST = "material_customize_material_color_details_list";
	
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_TITLE = "material_customize_material_view_title";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_BOUND_WIDTH = "material_customize_material_view_bound_width";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_BOUND_HEIGHT = "material_customize_material_view_bound_height";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_X = "material_customize_material_view_x";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_Y = "material_customize_material_view_y";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_Z = "material_customize_material_view_z";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_SCALE = "material_customize_material_view_scale";
	public static String MATERIAL_CUSTOMIZE_MATERIAL_VIEW_BORDER_DETAILS_LIST = "material_customize_material_view_border_details_list";
	
	static {

		createModeMap.put(MATERIAL_ID, WebComponent.MODE_HIDDEN);
		createModeMap.put(MATERIAL_GROUP_ID, WebComponent.MODE_EDITABLE);		
		createModeMap.put(MATERIAL_NAME_EN, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_NAME_HK, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_NAME_CN, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_THUMBNAIL_URL, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_DESIGNER_CLIENT_ID, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_MODEL, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_STOCK, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_MANUFACTURER_ID, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_PRICE, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_AVAILABLED_DATE, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_WEIGHT, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_LENGTH, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_WIDTH, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_HEIGHT, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_SORTING_ORDER, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_STOCK_STATUS, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_STATUS, WebComponent.MODE_EDITABLE);
		createModeMap.put(MATERIAL_CREATE_TIMESTAMP, WebComponent.MODE_HIDDEN);
		createModeMap.put(MATERIAL_LAST_MODIFIED_TIMESTAMP, WebComponent.MODE_HIDDEN);
		createModeMap.put(MATERIAL_CUSTOMIZE_MATERIAL_BASE, WebComponent.MODE_EDITABLE);
		
		
		updateModeMap.put(MATERIAL_ID, WebComponent.MODE_READONLY);
		updateModeMap.put(MATERIAL_GROUP_ID, WebComponent.MODE_EDITABLE);		
		updateModeMap.put(MATERIAL_NAME_EN, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_NAME_HK, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_NAME_CN, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_THUMBNAIL_URL, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_DESIGNER_CLIENT_ID, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_MODEL, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_STOCK, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_MANUFACTURER_ID, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_PRICE, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_AVAILABLED_DATE, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_WEIGHT, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_LENGTH, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_WIDTH, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_HEIGHT, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_SORTING_ORDER, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_STOCK_STATUS, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_STATUS, WebComponent.MODE_EDITABLE);
		updateModeMap.put(MATERIAL_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		updateModeMap.put(MATERIAL_LAST_MODIFIED_TIMESTAMP, WebComponent.MODE_READONLY);
		updateModeMap.put(MATERIAL_CUSTOMIZE_MATERIAL_BASE, WebComponent.MODE_EDITABLE);
		
		readOnlyModeMap.put(MATERIAL_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_GROUP_ID, WebComponent.MODE_READONLY);		
		readOnlyModeMap.put(MATERIAL_NAME_EN, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_NAME_HK, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_NAME_CN, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_THUMBNAIL_URL, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_DESIGNER_CLIENT_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_MODEL, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_STOCK, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_MANUFACTURER_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_PRICE, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_AVAILABLED_DATE, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_WEIGHT, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_LENGTH, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_WIDTH, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_HEIGHT, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_SORTING_ORDER, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_STOCK_STATUS, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_STATUS, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_LAST_MODIFIED_TIMESTAMP, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MATERIAL_CUSTOMIZE_MATERIAL_BASE, WebComponent.MODE_READONLY);
		
	}

}