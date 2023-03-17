package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class WebComponent {

	private static final Logger LOGGER = LogManager.getLogger(WebComponent.class.getName());
	
	public final static int EXTRA_TEXT_TYPE_NULL = 0;
	public final static int EXTRA_TEXT_TYPE_STATUS = 1;
	public final static int EXTRA_TEXT_TYPE_DATE_TIME = 2;
	public final static int EXTRA_TEXT_TYPE_DATE = 3;
	public final static int EXTRA_TEXT_TYPE_QUANTITY = 4;
	public final static int EXTRA_TEXT_TYPE_PRICE = 5;

	public final static int SEARCH_TEXT_INPUT_TYPE_CLIENT_ID = 0;
	public final static int SEARCH_TEXT_INPUT_TYPE_USER_ID = 1;
	public final static int SEARCH_TEXT_INPUT_TYPE_INSTRUMENT_CODE = 2;
	public final static int SEARCH_TEXT_INPUT_TYPE_AE_CLIENT_ID = 3;
	
	public final static int NUMBER_INPUT_TYPE_NUMBER = 0;
	public final static int NUMBER_INPUT_TYPE_BALANCE = 1;
	public final static int NUMBER_INPUT_TYPE_PRICE = 2;
	public final static int NUMBER_INPUT_TYPE_AVERAGE_PRICE = 3;
	public final static int NUMBER_INPUT_TYPE_PERCENTAGE = 4;
	public final static int NUMBER_INPUT_TYPE_QUANTITY = 5;
	public final static int NUMBER_INPUT_TYPE_AMOUNT = 6;
	
	public final static int DATE_SELECT_TYPE_DATE = 0;
	public final static int DATE_SELECT_TYPE_DATE_TIME = 1;
	public final static int DATE_SELECT_TYPE_TIME = 2;
	
	public final static int DATE_PICKER_TYPE_DATE = 0;
	public final static int DATE_PICKER_TYPE_YEAR_DATE = 1;
	
	public final static int TIME_PICKER_TYPE_YEAR_DATE_TIME = 0;
	public final static int TIME_PICKER_TYPE_DATE_TIME = 1;
	public final static int TIME_PICKER_TYPE_TIME = 2;

	public final static int DATE_SELECT_WEEKENDS = 0;
	public final static int DATE_SELECT_HOLIDAY = 1;
	
	public final static int MODE_EDITABLE = 0;
	public final static int MODE_READONLY = 1;
	public final static int MODE_DISABLED = 2;
	public final static int MODE_HIDDEN = 3;
	public final static int MODE_PENDING_CONFIRM = 4;
	public final static int MODE_PENDING_APPROVAL = 5;

	public final static int PAGE_MODE_CREATE = 0;
	public final static int PAGE_MODE_UPDATE = 1;
	public final static int PAGE_MODE_READONLY = 2;
	public final static int PAGE_MODE_CONFIRM = 3;

	protected String key;
	protected int index;
	protected int mandatoryFlag;

	protected int createMode;
	protected int updateMode;
	protected int readOnlyMode;
	protected int confirmMode;

	public final static String KEY_WEB_COMPONENT_KEY = "webComponentKey";
	public final static String KEY_LABEL_WIDTH = "labelWidth";
	public final static String KEY_CONVERT_TYPE = "convertType";
	public final static String KEY_MANDATORY_FLAG = "mandatoryFlag";
	public final static String KEY_INDEX = "index";	
	public final static String KEY_CREATE_MODE = "createMode";
	public final static String KEY_UPDATE_MODE = "updateMode";
	public final static String KEY_READONLY_MODE = "readOnlyMode";
	public final static String KEY_CONFIRM_MODE = "confirmMode";

	public WebComponent( Map<String, Object> valueMap) {

		if (valueMap.containsKey(KEY_WEB_COMPONENT_KEY)) {
			this.key = (String) valueMap.get(KEY_WEB_COMPONENT_KEY);
		}
		
		if (valueMap.containsKey(KEY_INDEX)){
			this.index = (Integer) valueMap.get(KEY_INDEX);
		}

		if (valueMap.containsKey(KEY_MANDATORY_FLAG)) {
			this.mandatoryFlag = 1;
		} else {
			this.mandatoryFlag = 0;
		}

		if (valueMap.containsKey(KEY_CREATE_MODE)) {
			this.createMode = (Integer) valueMap.get(KEY_CREATE_MODE);
		}
		if (valueMap.containsKey(KEY_UPDATE_MODE)) {
			this.updateMode = (Integer) valueMap.get(KEY_UPDATE_MODE);
		}
		if (valueMap.containsKey(KEY_READONLY_MODE)) {
			this.readOnlyMode = (Integer) valueMap.get(KEY_READONLY_MODE);
		}
		if (valueMap.containsKey(KEY_CONFIRM_MODE)) {
			this.confirmMode = (Integer) valueMap.get(KEY_CONFIRM_MODE);
		}

	}


	public String getKey() {
		return key;
	}

	public boolean getMandatoryFlag(){
		return (mandatoryFlag==1);
	}
	
	public String getConvertedValue(String value, int convertType) {
		switch (convertType) {
		case EXTRA_TEXT_TYPE_STATUS:
			return "";
		case EXTRA_TEXT_TYPE_DATE:
			
			if ( value == null || value.equals("") || value.equals("0") )return "";
			
			if ( value.length() == 8) {
				
				String year = value.substring(0, 4);
				String month = value.substring(4, 6);
				String day = value.substring(6, 8);
				
				return year + "-" + month + "-" + day;
				
			}else{
				
				FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd", TimeZone.getTimeZone("Asia/Hong_Kong"));			
				try {
					return dateFormat.format(Long.parseLong(value));
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
					return "";
				}
			}
		case EXTRA_TEXT_TYPE_DATE_TIME:
			FastDateFormat dateTimeFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm", TimeZone.getTimeZone("Asia/Hong_Kong"));
			try {
				if(value.equals("0")) //0 timeStamp
					return "";
				else
					return dateTimeFormat.format(Long.parseLong(value));
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				return "";
			}
		case EXTRA_TEXT_TYPE_PRICE:
			return "$" + value;
		case EXTRA_TEXT_TYPE_QUANTITY:
			return value;
		default:
			return value;
		}
	}

	public int getComponentMode(int pageMode) {
		switch (pageMode) {
		case PAGE_MODE_CREATE:
			return createMode;
		case PAGE_MODE_UPDATE:
			return updateMode;
		case PAGE_MODE_READONLY:
			return readOnlyMode;
		case PAGE_MODE_CONFIRM:
			return confirmMode;
		default:
			return readOnlyMode;
		}
	}


	public abstract String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue);
	
	public String getWebComponentHtmlWithLang(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue, String lang){
		return "";
	}
	
	public String getWebComponentHtmlWithExtraHints(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue, String extraHints){
		return "";
	}
			
	public String getWebComponentHtmlSelection(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, List<String> labelList,
			Object value, Object origValue){
		
		return "";
	}


	protected static String objectToString(Object object) {
		return (object == null) ? "" : String.valueOf(object);
	}
	
	protected boolean isValueChange(String value, String oringinalValue) {
		if ( /*!oringinalValue.equals("") &&*/  !oringinalValue.equals(value)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isHidden(int pageMode) {
		switch (pageMode) {
		case PAGE_MODE_CREATE:
			return checkHidden(createMode);
		case PAGE_MODE_UPDATE:
			return checkHidden(updateMode);
		case PAGE_MODE_READONLY:
			return checkHidden(readOnlyMode);
		case PAGE_MODE_CONFIRM:
			return checkHidden(confirmMode);
		}
		return false;
	}

	public boolean checkHidden(int mode) {
		if (mode == MODE_HIDDEN) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getDisplay(ResourceBundle resourceBundle, String key) {
		try {
			
			if ( resourceBundle == null ){
				
				return key;
				
			}
			
			if ( resourceBundle.containsKey( key ) ){
				return resourceBundle.getString(key);
			}
			return key;
		} catch (MissingResourceException e) {
			return key;
		}
	}
}