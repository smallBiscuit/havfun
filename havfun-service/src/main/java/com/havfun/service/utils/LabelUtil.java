package com.havfun.service.utils;

import java.util.ResourceBundle;

public class LabelUtil {

	public static ResourceBundle getResourceBundle( String prefix, String lang){
		
		ResourceBundle labels = ResourceBundle.getBundle( prefix +"_"+ lang);
		
		return labels;
		
	}
	
	public static String getDisplayValueFromResourceBundle( ResourceBundle bundle, String key ){
		
		if ( bundle == null || key == null ){
		
			return key;
			
		}
		
		if ( !bundle.containsKey( key ) ){
			
			return key;
			
		}
		
		return bundle.getString( key );
	}
	
	public static boolean isValidFormValue( String value ){
		
		if ( value == null || value.trim().equals( "" ) ){
			
			return false;
			
		}
		
		return true;
		
	}
	
	public static String parseValidFormValue( String value ){
		
		return value.trim();
		
	}
	
	public static String parseValidFormNumberValue( String value ){
		
		return value.replace(",", "").trim();
		
	}
}
