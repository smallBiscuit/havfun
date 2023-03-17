package com.havfun.adminui.utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;

public class DisplayFormatHelper {

	public static final String DISPLAY_DATE_FORMAT_TIME_DETAIL = "HH:mm:ss";
	public static final String DISPLAY_DATE_FORMAT_TIME = "HH:mm";
	public static final String DISPLAY_DATE_FORMAT_DATE = "MM-dd";
	public static final String DISPLAY_DATE_FORMAT_DATE_TIME = "MM-dd HH:mm";	
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE = "yyyy-MM-dd";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE_TIME = "yyyy-MM-dd HH:mm";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE_TIME_DETAIL = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATA_DATE_FORMAT_DATE = "MMdd";
	public static final String DATA_DATE_FORMAT_YEAR_DATE = "yyyyMMdd";
	public static final String DATA_DATE_FORMAT_TIMER = "HHmm";
	
	public static final String DISPLAY_NUMBER_FORMAT_NUMBER = "0.######";		
	public static final String DISPLAY_NUMBER_FORMAT_BALANCE = "$#,###,##0.00;($#,###,##0.00)";
	public static final String DISPLAY_NUMBER_FORMAT_BALANCE_WO_SYMBOL = "#,###,##0.00;(#,###,##0.00)";
	public static final String DISPLAY_NUMBER_FORMAT_PRICE = "0.000";
	public static final String DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE = "0.####";
	public static final String DISPLAY_NUMBER_FORMAT_PERCENTAGE = "0.####";
	public static final String DISPLAY_NUMBER_FORMAT_PERCENTAGE_SHORT = "#.00";	
	public static final String DISPLAY_NUMBER_FORMAT_QUANTITY = "#,###,##0";

	private static TimeZone hktTimeZone = TimeZone.getTimeZone("Asia/Hong_Kong");	
	
	public static String getDisplayValueFromResourceBundle( ResourceBundle labels, String key ){
		
		if ( key == null || key.equals("") )return "";
		
		if ( labels == null )return "";
		
		if ( labels.containsKey(  key ))
			return labels.getString( key);
		
		return key;
		
	}
	
	public static String getDisplayValue(Number number, String displayFormat) {
		if (isDateFormat(displayFormat)) {
			
			if ( displayFormat.equals( DISPLAY_DATE_FORMAT_YEAR_DATE) ){
				
				return convertServerDateToDisplayFormat( number );
				
			}else if ( displayFormat.equals( DISPLAY_DATE_FORMAT_TIME) ){
				
				return convertServerTimeToDisplayFormat( number );
				
			}else {
			
				FastDateFormat formatter = FastDateFormat.getInstance(displayFormat, hktTimeZone);
				return formatter.format(number);
			
			}
			
		} else if (isNumberFormat(displayFormat)) {
			
			if ( displayFormat.equals( DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE) ){
				
				DecimalFormat formatter = new DecimalFormat(displayFormat);			
				
				return formatter.format(number);				
				
			}
			
			DecimalFormat formatter = new DecimalFormat(displayFormat);			
			
			return formatter.format(number);
			
		} else {
			return String.valueOf(number);
		}
	}

	private static boolean isDateFormat(String displayFormat) {
		if (Arrays.asList(
				DISPLAY_DATE_FORMAT_TIME_DETAIL,
				DISPLAY_DATE_FORMAT_TIME, 
				DISPLAY_DATE_FORMAT_DATE, 
				DISPLAY_DATE_FORMAT_DATE_TIME,
				DISPLAY_DATE_FORMAT_YEAR_DATE, 
				DISPLAY_DATE_FORMAT_YEAR_DATE_TIME,
				DISPLAY_DATE_FORMAT_YEAR_DATE_TIME_DETAIL,
				DATA_DATE_FORMAT_DATE,
				DATA_DATE_FORMAT_YEAR_DATE,
				DATA_DATE_FORMAT_TIMER).contains(displayFormat)) {
			
			return true;
		} else {
			return false;
		}
	}

	private static boolean isNumberFormat(String displayFormat) {
		if (Arrays.asList(DISPLAY_NUMBER_FORMAT_BALANCE, 
				DISPLAY_NUMBER_FORMAT_BALANCE_WO_SYMBOL, 
				DISPLAY_NUMBER_FORMAT_PRICE, 
				DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE, 
				DISPLAY_NUMBER_FORMAT_QUANTITY, 
				DISPLAY_NUMBER_FORMAT_NUMBER).contains(displayFormat)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static String convertServerDateToDisplayFormat( Number number ){
		
		String dateStr = String.valueOf( number );
		
		String yearStr = dateStr.substring(0, 4);
		String monthStr = dateStr.substring(4, 6);
		String dayStr = dateStr.substring(6, 8);
		
		return yearStr + "-" + monthStr + "-" + dayStr;
		
	}
	
	private static String convertServerTimeToDisplayFormat( Number number ){
		
		String dateStr = String.format("%04d", number);
		
		String hourStr = dateStr.substring(0, 2);
		String minStr = dateStr.substring(2, 4);
		
		return hourStr + ":" + minStr;
		
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
	
}
