package com.havfun.adminui.product;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.CustomizeProductBaseForm;
import com.havfun.adminui.webcomponent.DateSelect;
import com.havfun.adminui.webcomponent.NumberInput;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface ProductHelper extends AbstractDataHelper {

	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String PRODUCT_JSP = "/WEB-INF/product.jsp";
	public static final String SEARCH_PRODUCT_JSP = "/WEB-INF/searchProduct.jsp";

	public static final String CREATE_PRODUCT = "CreateProduct";
	public static final String CREATE_PRODUCT_REQUEST = "CreateProductRequest";
	public static final String ENQUIRE_PRODUCT = "EnquireProduct";
	public static final String UPDATE_PRODUCT_REQUEST = "UpdateProductRequest";

	public WebComponent PRODUCT_ID = new TextInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_ID), 8);
	public WebComponent PRODUCT_GROUP_ID = new Select( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_GROUP_ID) );
	public WebComponent PRODUCT_NAME_EN = new TextInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_NAME_EN), 255);
	public WebComponent PRODUCT_NAME_HK = new TextInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_NAME_HK), 255);
	public WebComponent PRODUCT_NAME_CN = new TextInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_NAME_CN), 255);
	public WebComponent PRODUCT_THUMBNAIL_URL = new TextInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_THUMBNAIL_URL), 255);
	public WebComponent PRODUCT_DESIGNER_CLIENT_ID = new TextInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_DESIGNER_CLIENT_ID), 20);
	public WebComponent PRODUCT_MODEL = new TextInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_MODEL), 20);
	public WebComponent PRODUCT_STOCK = new NumberInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_STOCK), WebComponent.NUMBER_INPUT_TYPE_QUANTITY, 10, 0, 0 );
	public WebComponent PRODUCT_MANUFACTURER_ID = new TextInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_MANUFACTURER_ID), 20);
	public WebComponent PRODUCT_PRICE = new NumberInput( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_PRICE), WebComponent.NUMBER_INPUT_TYPE_BALANCE, 10, 2, 0);
	public WebComponent PRODUCT_AVAILABLED_DATE = new TextInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_AVAILABLED_DATE), 20);
	public WebComponent PRODUCT_WEIGHT = new NumberInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_WEIGHT), WebComponent.NUMBER_INPUT_TYPE_NUMBER, 10, 4, 0);
	public WebComponent PRODUCT_LENGTH = new NumberInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_LENGTH), WebComponent.NUMBER_INPUT_TYPE_NUMBER, 10, 4, 0);
	public WebComponent PRODUCT_WIDTH = new NumberInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_WIDTH), WebComponent.NUMBER_INPUT_TYPE_NUMBER, 10, 4, 0);
	public WebComponent PRODUCT_HEIGHT = new NumberInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_HEIGHT), WebComponent.NUMBER_INPUT_TYPE_NUMBER, 10, 4, 0);
	public WebComponent PRODUCT_SORTING_ORDER = new TextInput(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_SORTING_ORDER), 20);
	public WebComponent PRODUCT_STOCK_STATUS = new Select(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_STOCK_STATUS));
	public WebComponent PRODUCT_STATUS = new Select(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_STATUS));
	public TimePicker PRODUCT_CREATE_TIMESTAMP = new TimePicker(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_CREATE_TIMESTAMP) );
	public TimePicker PRODUCT_LAST_MODIFIED_TIMESTAMP = new TimePicker(
			ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_LAST_MODIFIED_TIMESTAMP) );
	public WebComponent PRODUCT_CUSTOMIZE_PRODUCT_BASE = new CustomizeProductBaseForm( ProductComponentConfig.getValueMapByKey(ProductComponentConfig.PRODUCT_CUSTOMIZE_PRODUCT_BASE) );

	
}
