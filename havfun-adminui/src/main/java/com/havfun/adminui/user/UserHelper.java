package com.havfun.adminui.user;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.DateSelect;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface UserHelper extends AbstractDataHelper{
	
	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String USER_JSP = "/WEB-INF/user.jsp";
	public static final String SEARCH_USER_JSP = "/WEB-INF/searchUser.jsp";

	
	public static final String CREATE_USER = "CreateUser";
	public static final String CREATE_USER_REQUEST = "CreateUserRequest";
	public static final String ENQUIRE_USER = "EnquireUser";
	public static final String UPDATE_USER_REQUEST = "UpdateUserRequest";
	public static final String CONFIRM_USER = "ConfirmUser";
	public static final String CONFIRM_USER_REQUEST = "ConfirmUserRequest";	
	

	public WebComponent USER_ID = new TextInput( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_ID ), 8 );
	public WebComponent USER_GROUP = new Select( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_GROUP ) );
	public WebComponent USER_NAME = new TextInput( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_NAME ), 20 );
	public WebComponent USER_PASSCODE = new TextInput( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_PASSCODE ), 20 );
	public WebComponent USER_FIRST_NAME = new TextInput( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_FIRST_NAME ), 20 );
	public WebComponent USER_LAST_NAME = new TextInput( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_LAST_NAME ), 20 );
	public WebComponent USER_EMAIL = new TextInput( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_EMAIL ), 20 );
	public WebComponent USER_STATUS = new Select( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_STATUS ) );
	public TimePicker USER_CREATE_TIMESTAMP = new TimePicker( UserComponentConfig.getValueMapByKey( UserComponentConfig.USER_CREATE_TIMESTAMP ) );
	
}
