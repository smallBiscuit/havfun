package com.havfun.adminui.productgroup;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.DateSelect;
import com.havfun.adminui.webcomponent.FileInput;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface ProductGroupHelper extends AbstractDataHelper{
	
	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String PRODUCT_GROUP_JSP = "/WEB-INF/productGroup.jsp";
	public static final String SEARCH_PRODUCT_GROUP_JSP = "/WEB-INF/searchProductGroup.jsp";

	
	public static final String CREATE_PRODUCT_GROUP = "CreateProductGroup";
	public static final String CREATE_PRODUCT_GROUP_REQUEST = "CreateProductGroupRequest";
	public static final String ENQUIRE_PRODUCT_GROUP = "EnquireProductGroup";
	public static final String UPDATE_PRODUCT_GROUP_REQUEST = "UpdateProductGroupRequest";
	

	public WebComponent PRODUCT_GROUP_ID = new TextInput( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_ID ), 8 );
	public WebComponent PRODUCT_GROUP_NAME_EN = new TextInput( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_NAME_EN ), 255 );
	public WebComponent PRODUCT_GROUP_IMAGE = new FileInput( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_IMAGE ) );
	public WebComponent PRODUCT_GROUP_PARENT_ID = new TextInput( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_PARENT_ID ), 20 );
	public WebComponent PRODUCT_GROUP_STATUS = new Select( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_STATUS ) );
	public TimePicker PRODUCT_GROUP_CREATE_TIMESTAMP = new TimePicker( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_CREATE_TIMESTAMP ) );
	public TimePicker PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP = new TimePicker( ProductGroupComponentConfig.getValueMapByKey( ProductGroupComponentConfig.PRODUCT_GROUP_LAST_MODIFIED_TIMESTAMP ) );
	
}
