package com.havfun.adminui.utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ResourceBundle;

import org.apache.commons.lang3.time.FastDateFormat;

public class NumberFormatUtil {

	public static final String DISPLAY_NUMBER_FORMAT_BALANCE = "$#,###,##0.00;($#,###,##0.00)";
	public static final String DISPLAY_NUMBER_FORMAT_BALANCE_WO_SYMBOL = "#,###,##0.00;(#,###,##0.00)";
	public static final String DISPLAY_NUMBER_FORMAT_PRICE = "0.000";
	public static final String DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE = "0.####";
	public static final String DISPLAY_NUMBER_FORMAT_NUMBER = "0.######";	
	public static final String DISPLAY_NUMBER_FORMAT_PERCENTAGE = "#.00";
	public static final String DISPLAY_NUMBER_FORMAT_QUANTITY = "#,###,##0";

	public static String getDisplayInBalanceFormat( Number number ) {
		
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_BALANCE );					
			
		return formatter.format(number);

	}

	
	public static String getDisplayInBalanceFormatWithoutSymbol( Number number ) {
		
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_BALANCE_WO_SYMBOL );					
			
		return formatter.format(number);

	}

	public static String getDisplayInPriceFormat( Number number ) {
		
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_PRICE );					
			
		return formatter.format(number);
	
	}
	
	public static String getDisplayInAveragePriceFormat( Number number ) {
		
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE );					
			
		return formatter.format(number);
	
	}
	
	public static String getDisplayInNumberFormat( Number number ) {
		
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_NUMBER );					
			
		return formatter.format(number);
	
	}

	public static String getDisplayInPercentageFormat( Number number ) {
	
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_PERCENTAGE );					
		
	return formatter.format(number);

}
	
	public static String getDisplayInQuantityFormat( Number number ) {
		
		DecimalFormat formatter = new DecimalFormat(  DISPLAY_NUMBER_FORMAT_QUANTITY );					
			
		return formatter.format(number);

	}
	
}
