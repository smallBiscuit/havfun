package com.havfun.adminui.materialgroup;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.DateSelect;
import com.havfun.adminui.webcomponent.FileInput;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface MaterialGroupHelper extends AbstractDataHelper{
	
	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String MATERIAL_GROUP_JSP = "/WEB-INF/materialGroup.jsp";
	public static final String SEARCH_MATERIAL_GROUP_JSP = "/WEB-INF/searchMaterialGroup.jsp";

	
	public static final String CREATE_MATERIAL_GROUP = "CreateMaterialGroup";
	public static final String CREATE_MATERIAL_GROUP_REQUEST = "CreateMaterialGroupRequest";
	public static final String ENQUIRE_MATERIAL_GROUP = "EnquireMaterialGroup";
	public static final String UPDATE_MATERIAL_GROUP_REQUEST = "UpdateMaterialGroupRequest";
	

	public WebComponent MATERIAL_GROUP_ID = new TextInput( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_ID ), 8 );
	public WebComponent MATERIAL_GROUP_NAME_EN = new TextInput( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_NAME_EN ), 255 );
	public WebComponent MATERIAL_GROUP_IMAGE = new FileInput( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_IMAGE ) );
	public Select MATERIAL_GROUP_PARENT_ID = new Select( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_PARENT_ID ) );
	public WebComponent MATERIAL_GROUP_STATUS = new Select( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_STATUS ) );
	public TimePicker MATERIAL_GROUP_CREATE_TIMESTAMP = new TimePicker( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_CREATE_TIMESTAMP ) );
	public TimePicker MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP = new TimePicker( MaterialGroupComponentConfig.getValueMapByKey( MaterialGroupComponentConfig.MATERIAL_GROUP_LAST_MODIFIED_TIMESTAMP ) );
	
}
