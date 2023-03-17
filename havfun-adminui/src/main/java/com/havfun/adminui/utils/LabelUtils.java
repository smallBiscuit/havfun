package com.havfun.adminui.utils;

import java.util.ResourceBundle;

public class LabelUtils {
	
	public static boolean isFormValueValid( String value ){
		
		if ( value == null || value.trim().equals( "" ) ){
			
			return false;
			
		}
		
		return true;
		
	}
	
	public static String convertFormValueToValidFilter( String value ){
		
		if ( value == null ){
			
			return null;
			
		}
		
		return value.trim();
		
	}
	
	public static String convertFormValueToValidNumberFilter( String value ){
		
		if ( value == null ){
			
			return null;
			
		}
		
		return value.trim().replace(",", "" );
		
	}
	
	public static String getDisplayValueFromResourceBundle( ResourceBundle labels, String key ){
		
		if ( key == null || key.equals("") )return "";
		
		if ( labels == null )return "";
		
		if ( labels.containsKey(  key ))
			return labels.getString( key);
		
		return key;
		
	}
	
	public static String getDisplayValueFromResourceBundle( ResourceBundle labels, String key, String extraHints ){
		
		String finalExtraHints = "";
		
		if ( extraHints != null ){
			finalExtraHints = " (" + extraHints + ")";
		}
		
		if ( key == null || key.equals("") ){
			
			return finalExtraHints;
			
		}
		
		if ( labels == null ){
			
			return finalExtraHints;
			
		}
		
		if ( labels.containsKey(  key ) ){
			return labels.getString( key) + finalExtraHints;
		
		}
		
		return key + finalExtraHints;
		
	}

	public static String getDisplayName( String lang, String nameEn, String nameHk, String nameCn, String defaultValue ){
		
		String displayName = defaultValue;
		
		if ( lang == null ){
			
			return "en";
			
		}
		
		
		
		if ( lang.equals("zh_HK") ){
			
			displayName = nameHk;
			
		}else if ( lang.equals("zh_CN") ){
			
			displayName = nameCn;
			
		}else {
			
			displayName = nameEn;
			
		}
		
		if ( displayName == null || displayName.equals("" )){
		
			displayName = nameEn;
			
		}
		
		if ( displayName == null || displayName.equals("" )){
			
			displayName = defaultValue;
			
		}
		
		return displayName;
		
	}
	
	public static String emojiFilter(String str){
		
        if(str == null || str.length() == 0){
            return "";
        }

        return str.replaceAll("[^\\u0000-\\uFFFF]", "\uFFFD");
        
    }
}
