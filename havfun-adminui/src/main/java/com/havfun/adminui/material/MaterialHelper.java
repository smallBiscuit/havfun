package com.havfun.adminui.material;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.DateSelect;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface MaterialHelper extends AbstractDataHelper {

	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String MATERIAL_JSP = "/WEB-INF/material.jsp";
	public static final String SEARCH_MATERIAL_JSP = "/WEB-INF/searchMaterial.jsp";

	public static final String CREATE_MATERIAL = "CreateMaterial";
	public static final String CREATE_MATERIAL_REQUEST = "CreateMaterialRequest";
	public static final String ENQUIRE_MATERIAL = "EnquireMaterial";
	public static final String UPDATE_MATERIAL_REQUEST = "UpdateMaterialRequest";

	public WebComponent MATERIAL_ID = new TextInput( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_ID), 8);
	public WebComponent MATERIAL_GROUP_ID = new Select( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_GROUP_ID) );
	public WebComponent MATERIAL_NAME_EN = new TextInput( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_NAME_EN), 255);
	public WebComponent MATERIAL_NAME_HK = new TextInput( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_NAME_HK), 255);
	public WebComponent MATERIAL_NAME_CN = new TextInput( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_NAME_CN), 255);
	public WebComponent MATERIAL_THUMBNAIL_URL = new TextInput( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_THUMBNAIL_URL), 255);
	public WebComponent MATERIAL_DESIGNER_CLIENT_ID = new TextInput( MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_DESIGNER_CLIENT_ID), 20);
	public WebComponent MATERIAL_MODEL = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_MODEL), 20);
	public WebComponent MATERIAL_STOCK = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_STOCK), 20);
	public WebComponent MATERIAL_MANUFACTURER_ID = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_MANUFACTURER_ID), 20);
	public WebComponent MATERIAL_PRICE = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_PRICE), 20);
	public WebComponent MATERIAL_AVAILABLED_DATE = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_AVAILABLED_DATE), 20);
	public WebComponent MATERIAL_WEIGHT = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_WEIGHT), 20);
	public WebComponent MATERIAL_LENGTH = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_LENGTH), 20);
	public WebComponent MATERIAL_WIDTH = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_WIDTH), 20);
	public WebComponent MATERIAL_HEIGHT = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_HEIGHT), 20);
	public WebComponent MATERIAL_SORTING_ORDER = new TextInput(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_SORTING_ORDER), 20);
	public WebComponent MATERIAL_STOCK_STATUS = new Select(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_STOCK_STATUS));
	public WebComponent MATERIAL_STATUS = new Select(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_STATUS));
	public TimePicker MATERIAL_CREATE_TIMESTAMP = new TimePicker(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_CREATE_TIMESTAMP) );
	public TimePicker MATERIAL_LAST_MODIFIED_TIMESTAMP = new TimePicker(
			MaterialComponentConfig.getValueMapByKey(MaterialComponentConfig.MATERIAL_LAST_MODIFIED_TIMESTAMP) );

	
}
