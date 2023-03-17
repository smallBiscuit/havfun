package com.havfun.adminui.helper;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;

public class DisplayFormatHelper {

	public static final String DISPLAY_DATE_FORMAT_DATE = "MM-dd";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE = "yyyy-MM-dd";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE_TIME = "yyyy-MM-dd HH:mm";
	public static final String DISPLAY_DATE_FORMAT_SERVER_DATE = "yyyyMMdd";
	public static final String DISPLAY_SERVER_TIME_FORMAT = "HHmm";
	public static final String DISPLAY_TIME_FORMAT = "HH:mm";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE_TIME_DETAIL = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DISPLAY_NUMBER_FORMAT_NUMBER = "0.######";	//Default
	public static final String DISPLAY_NUMBER_FORMAT_BALANCE = "$#,###,##0.00;($#,###,##0.00)";
	public static final String DISPLAY_NUMBER_FORMAT_PRICE = "0.000";
	public static final String DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE = "0.####";
	public static final String DISPLAY_NUMBER_FORMAT_PERCENTAGE = "0.####";
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
			FastDateFormat formatter = FastDateFormat.getInstance(displayFormat, hktTimeZone);
			return formatter.format(number);
		} else if (isNumberFormat(displayFormat)) {
			DecimalFormat formatter = new DecimalFormat(displayFormat);
			return formatter.format(number);
		} else {
			return String.valueOf(number);
		}
	}
	
	public static String convertServerTimeToDisplayFormat( Number number ){
		
		String dateStr = String.format("%04d", number);
		
		String hourStr = dateStr.substring(0, 2);
		String minStr = dateStr.substring(2, 4);
		
		return hourStr + ":" + minStr;
		
	}

	private static boolean isDateFormat(String displayFormat) {
		if (Arrays.asList(DISPLAY_TIME_FORMAT, DISPLAY_DATE_FORMAT_DATE, DISPLAY_DATE_FORMAT_YEAR_DATE, DISPLAY_DATE_FORMAT_YEAR_DATE_TIME, DISPLAY_DATE_FORMAT_SERVER_DATE).contains(displayFormat)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isNumberFormat(String displayFormat) {
		if (Arrays.asList(DISPLAY_NUMBER_FORMAT_NUMBER, DISPLAY_NUMBER_FORMAT_BALANCE, DISPLAY_NUMBER_FORMAT_PRICE, DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE, DISPLAY_NUMBER_FORMAT_PERCENTAGE, DISPLAY_NUMBER_FORMAT_QUANTITY ).contains(displayFormat)) {
			return true;
		} else {
			return false;
		}
	}
	
}
