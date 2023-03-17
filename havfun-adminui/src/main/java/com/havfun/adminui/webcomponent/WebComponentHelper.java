package com.havfun.adminui.webcomponent;

public class WebComponentHelper {

	public static String objectToString(Object object) {
		return (object == null) ? "" : String.valueOf(object);
	}
	
	public static boolean isValueChange(String value, String oringinalValue) {
		if ( /*!oringinalValue.equals("") &&*/  !oringinalValue.equals(value)) {
			return true;
		} else {
			return false;
		}
	}
	
}
