package com.havfun.adminui.product;

import com.havfun.adminui.servlet.AbstractComponentConfig;
import com.havfun.adminui.webcomponent.WebComponent;

public class ProductComponentConfig extends AbstractComponentConfig {

	public static String PRODUCT_ID = "product_id";
	public static String PRODUCT_GROUP_ID = "product_group_id";
	public static String PRODUCT_NAME_EN = "product_name_en";
	public static String PRODUCT_NAME_HK = "product_name_hk";
	public static String PRODUCT_NAME_CN = "product_name_cn";
	public static String PRODUCT_THUMBNAIL_URL = "product_thumbnail_url";
	public static String PRODUCT_DESIGNER_CLIENT_ID = "product_designer_client_id";
	public static String PRODUCT_MODEL = "product_model";
	public static String PRODUCT_STOCK = "product_stock";
	public static String PRODUCT_MANUFACTURER_ID = "product_manufacturer_id"; 
	public static String PRODUCT_PRICE = "product_price";
	public static String PRODUCT_AVAILABLED_DATE = "product_available_date";
	public static String PRODUCT_WEIGHT = "product_weight";
	public static String PRODUCT_LENGTH = "product_length";
	public static String PRODUCT_WIDTH = "product_width";
	public static String PRODUCT_HEIGHT = "product_height";
	public static String PRODUCT_SORTING_ORDER = "product_sorting_order";
	public static String PRODUCT_STOCK_STATUS = "product_stock_status";
	public static String PRODUCT_STATUS = "product_status";
	public static String PRODUCT_CREATE_TIMESTAMP = "product_create_timestamp";
	public static String PRODUCT_LAST_MODIFIED_TIMESTAMP = "product_last_modified_timestamp";

	public static String PRODUCT_CUSTOMIZE_PRODUCT_BASE = "product_customize_product_base";
	
	public static String PRODUCT_CUSTOMIZE_PRODUCT_COLOR_DETAILS_LIST = "product_customize_product_color_details_list";
	
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_TITLE = "product_customize_product_view_title";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_BOUND_WIDTH = "product_customize_product_view_bound_width";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_BOUND_HEIGHT = "product_customize_product_view_bound_height";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_X = "product_customize_product_view_x";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_Y = "product_customize_product_view_y";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_Z = "product_customize_product_view_z";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_SCALE = "product_customize_product_view_scale";
	public static String PRODUCT_CUSTOMIZE_PRODUCT_VIEW_BORDER_DETAILS_LIST = "product_customize_product_view_border_details_list";
	
	static {

		createModeMap.put(PRODUCT_ID, WebComponent.MODE_HIDDEN);
		createModeMap.put(PRODUCT_GROUP_ID, WebComponent.MODE_EDITABLE);		
		createModeMap.put(PRODUCT_NAME_EN, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_NAME_HK, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_NAME_CN, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_THUMBNAIL_URL, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_DESIGNER_CLIENT_ID, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_MODEL, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_STOCK, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_MANUFACTURER_ID, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_PRICE, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_AVAILABLED_DATE, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_WEIGHT, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_LENGTH, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_WIDTH, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_HEIGHT, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_SORTING_ORDER, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_STOCK_STATUS, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_STATUS, WebComponent.MODE_EDITABLE);
		createModeMap.put(PRODUCT_CREATE_TIMESTAMP, WebComponent.MODE_HIDDEN);
		createModeMap.put(PRODUCT_LAST_MODIFIED_TIMESTAMP, WebComponent.MODE_HIDDEN);
		createModeMap.put(PRODUCT_CUSTOMIZE_PRODUCT_BASE, WebComponent.MODE_EDITABLE);
		
		
		updateModeMap.put(PRODUCT_ID, WebComponent.MODE_READONLY);
		updateModeMap.put(PRODUCT_GROUP_ID, WebComponent.MODE_EDITABLE);		
		updateModeMap.put(PRODUCT_NAME_EN, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_NAME_HK, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_NAME_CN, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_THUMBNAIL_URL, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_DESIGNER_CLIENT_ID, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_MODEL, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_STOCK, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_MANUFACTURER_ID, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_PRICE, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_AVAILABLED_DATE, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_WEIGHT, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_LENGTH, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_WIDTH, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_HEIGHT, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_SORTING_ORDER, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_STOCK_STATUS, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_STATUS, WebComponent.MODE_EDITABLE);
		updateModeMap.put(PRODUCT_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		updateModeMap.put(PRODUCT_LAST_MODIFIED_TIMESTAMP, WebComponent.MODE_READONLY);
		updateModeMap.put(PRODUCT_CUSTOMIZE_PRODUCT_BASE, WebComponent.MODE_EDITABLE);
		
		readOnlyModeMap.put(PRODUCT_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_GROUP_ID, WebComponent.MODE_READONLY);		
		readOnlyModeMap.put(PRODUCT_NAME_EN, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_NAME_HK, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_NAME_CN, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_THUMBNAIL_URL, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_DESIGNER_CLIENT_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_MODEL, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_STOCK, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_MANUFACTURER_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_PRICE, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_AVAILABLED_DATE, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_WEIGHT, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_LENGTH, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_WIDTH, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_HEIGHT, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_SORTING_ORDER, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_STOCK_STATUS, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_STATUS, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_CREATE_TIMESTAMP, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_LAST_MODIFIED_TIMESTAMP, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(PRODUCT_CUSTOMIZE_PRODUCT_BASE, WebComponent.MODE_READONLY);
		
	}

}