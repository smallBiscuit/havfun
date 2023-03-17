package com.havfun.adminui.client;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.AddressList;
import com.havfun.adminui.webcomponent.DateSelect;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface ClientHelper extends AbstractDataHelper{
	
	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String CLIENT_JSP = "/WEB-INF/client.jsp";
	public static final String SEARCH_CLIENT_JSP = "/WEB-INF/searchClient.jsp";

	
	public static final String CREATE_CLIENT = "CreateClient";
	public static final String CREATE_CLIENT_REQUEST = "CreateClientRequest";
	public static final String ENQUIRE_CLIENT = "EnquireClient";
	public static final String UPDATE_CLIENT_REQUEST = "UpdateClientRequest";
	

	public WebComponent CLIENT_ID = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_ID ), 8 );
	public WebComponent CLIENT_FIRST_NAME = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_FIRST_NAME ), 20 );
	public WebComponent CLIENT_LAST_NAME = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_LAST_NAME ), 20 );
	public WebComponent CLIENT_BIRTH = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_BIRTH ), 20 );
	public WebComponent CLIENT_GENDER = new Select( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_GENDER ) );
	public WebComponent CLIENT_EMAIL = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_EMAIL ), 20 );
	public WebComponent CLIENT_TELEPHONE = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_TELEPHONE ), 20 );
	public WebComponent CLIENT_FAX = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_TELEPHONE ), 20 );
	public WebComponent CLIENT_ADDRESS_LIST = new AddressList( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_ADDRESS_LIST ) );
	public WebComponent CLIENT_REFERRER_CLIENT_ID = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_REFERRER_CLIENT_ID ), 20 );
	public WebComponent CLIENT_STORE_ID = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_STORE_ID ), 20 );
	public WebComponent CLIENT_NEWSLETTER = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_NEWSLETTER ), 20 );
	public WebComponent CLIENT_GROUP = new TextInput( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_GROUP ), 20 );
	public WebComponent CLIENT_STATUS = new Select( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_STATUS ) );
	public TimePicker CLIENT_CREATE_TIMESTAMP = new TimePicker( ClientComponentConfig.getValueMapByKey( ClientComponentConfig.CLIENT_CREATE_TIMESTAMP ) );
	
}
